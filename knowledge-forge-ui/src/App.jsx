// src/App.jsx
import React from 'react';
import { Route, BrowserRouter as Router, Routes, Navigate } from 'react-router-dom';
//import Login from './components/Login';
//import Register from './components/Register';
import TutorScheduleList from './components/TutorScheduleList';
import TutorScheduleDetail from './components/TutorScheduleDetail';
import TutorScheduleForm from './components/TutorScheduleForm';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Navigate to="/tutor-schedules" />} />
               {/* <Route path="/" element={<Login />} />
                <Route path="/register" element={<Register />} /> */}
                
                {/* Tutor Schedule Routes */}
                <Route path="/tutor-schedules" element={<TutorScheduleList />} />
                <Route path="/tutor-schedules/:scheduleId" element={<TutorScheduleDetail />} />
                <Route path="/tutor-schedules/create" element={<TutorScheduleForm isEdit={false} />} />
                <Route path="/tutor-schedules/update/:scheduleId" element={<TutorScheduleForm isEdit={true} />} />
            </Routes>
        </Router>
    );
};

export default App;
