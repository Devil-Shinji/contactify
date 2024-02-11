import './App.css';
import LoginForm from "./views/login";
import { BrowserRouter as Router, Route, Navigate, Routes } from 'react-router-dom';
import React, {useState} from "react";
import {IUserLogin} from "./lib/users/models";
import ContactsListPage from "./views/contacts";

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [user, setUserLogin] = useState<IUserLogin>(
        {username: "", password: ""}
    );

    const handleLogin = (user: IUserLogin) => {
        setUserLogin(user);
        setIsLoggedIn(true);
    };

    return (
        <Router>
            <Routes>
                <Route path="/" element={isLoggedIn ? <Navigate to="/contacts-list"/> : <div style={{
                    display: 'grid',
                    placeItems: 'center',
                    minHeight: '100vh',
                }}>
                    <LoginForm onLogin={handleLogin}/>
                </div>}/>
                <Route path="/contacts-list"
                       element={isLoggedIn ? <ContactsListPage user={user}/> : <Navigate to="/"/>}/>
            </Routes>
        </Router>
    );
}

export default App;
