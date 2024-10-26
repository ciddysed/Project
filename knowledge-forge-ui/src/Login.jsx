// src/Login.jsx
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/tutors/login?email=' + email, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
            });
            if (response.ok) {
                const data = await response.json();
                // Handle successful login (e.g., store user data or redirect)
                console.log('Login successful:', data);
            } else {
                setMessage('Login failed. Please check your credentials.');
            }
        } catch (error) {
            setMessage('Error occurred. Please try again.');
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <button type="submit">Login</button>
                {message && <p>{message}</p>}
            </form>
            <p>
                Don't have an account? <button onClick={() => navigate('/register')}>Register</button>
            </p>
        </div>
    );
};

export default Login;
