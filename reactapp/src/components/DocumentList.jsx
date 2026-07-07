import React,{useEffect,useState} from "react";
import axios from "axios";

export default function DocumentList(){
    const [documents,setDocuments]=useState([]);
    
    useEffect(()=>{
        axios.get("/api/documents")
        .then(response=>setDocuments(response.data))
        .catch(error=>console.error("Error fetching documents:",error))
    },[]);
    return(
        <div>
            <h2>Document List</h2>
            
            <ul>
                {documents.map(document=>(
                    <li key={document.id}>{document.name}</li>
                ))}
            </ul>
        </div>
    );
}