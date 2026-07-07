import React from 'react';
import {BrowserRouter,Routes,Route} from "react-router-dom";

import Home from './components/Home';
import Upload from './components/UploadPage';
import Documents from './components/DocumentList';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
export default function App(){
    return(
        <BrowserRouter>

            <Navbar/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/upload" element={<Upload/>}/>
                <Route path="/documents" element={<Documents/>}/>
            </Routes>
            <Footer/>
        </BrowserRouter>

    );
}