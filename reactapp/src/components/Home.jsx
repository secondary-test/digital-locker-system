import React from "react";
import { Link } from "react-router-dom";
export default function Home(){
    return(
        <div>
            <h1>Digital Locker</h1>
            <p>Manage your documents securely.</p>
            <Link to="/upload">Upload Document</Link>
        </div>
    )
}
