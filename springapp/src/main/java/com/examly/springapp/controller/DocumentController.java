package com.examly.springapp.controller;

import com.examly.springapp.model.Document;
import com.examly.springapp.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<Document> saveDocument(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) throws Exception {
        return ResponseEntity.ok(documentService.saveDocument(file.getOriginalFilename(), email, file.getBytes()));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Document>> getDocuments() {
        return ResponseEntity.ok(documentService.getDocuments());
    }
}
