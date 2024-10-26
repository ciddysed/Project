// src/Register.jsx
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Register = () => {
    const [tutorName, setTutorName] = useState('');
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/tutors/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ tutorName, email }),
            });
            if (response.ok) {
                const data = await response.json();
                // Handle successful registration (e.g., redirect to login)
                console.log('Registration successful:', data);
                navigate('/');
            } else {
                setMessage('Registration failed. Please try again.');
            }
        } catch (error) {
            setMessage('Error occurred. Please try again.');
        }
    };

    return (
        <div>
            <h2>Register</h2>
            <form onSubmit={handleRegister}>
                <input
                    type="text"
                    placeholder="Tutor Name"
                    value={tutorName}
                    onChange={(e) => setTutorName(e.target.value)}
                    required
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <button type="submit">Register</button>
                {message && <p>{message}</p>}
            </form>
            <p>
                Already have an account? <button onClick={() => navigate('/')}>Login</button>
            </p>
        </div>
    );
};

export default Register;
