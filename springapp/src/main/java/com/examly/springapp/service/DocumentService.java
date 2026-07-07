package com.examly.springapp.service;

import com.examly.springapp.model.Document;
import com.examly.springapp.repository.DocumentRepository;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(String filename, String email, byte[] data) {
        Document document = new Document();
        document.setFilename(filename);
        document.setEmail(email);
        document.setFileData(data);
        return documentRepository.save(document);
    }

    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocument(Long id) {
        return documentRepository.findById(id);
    }

    public List<Map<String, Object>> getAllMetadata() {
        return documentRepository.findAll().stream().map(document -> {
            Map<String, Object> metadata = new HashMap<>();
            metadata.put("id", document.getId());
            metadata.put("filename", document.getFilename());
            metadata.put("email", document.getEmail());
            return metadata;
        }).collect(Collectors.toList());
    }
}
