import React, { useState } from 'react';

const RegisterTutor = () => {
  const [formData, setFormData] = useState({
    username: '',
    tutorName: '',
    password: '',
    email: '',
    courseMajor: '',
    city: '',
    age: '',
    degrees: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    // Add your form submission logic here (e.g., API call)
  };

  return (
    <div className="tutor-register-container">
      <h2>Tutor Registration</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="tutorName">Tutor Name:</label>
          <input
            type="text"
            id="tutorName"
            name="tutorName"
            value={formData.tutorName}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="courseMajor">Course Major:</label>
          <input
            type="text"
            id="courseMajor"
            name="courseMajor"
            value={formData.courseMajor}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="city">City:</label>
          <input
            type="text"
            id="city"
            name="city"
            value={formData.city}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="age">Age:</label>
          <input
            type="number"
            id="age"
            name="age"
            value={formData.age}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="degrees">Degrees:</label>
          <input
            type="text"
            id="degrees"
            name="degrees"
            value={formData.degrees}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="primary-button">Register</button>
      </form>
    </div>
  );
};

export default RegisterTutor;
