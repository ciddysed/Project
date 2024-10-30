// src/pages/TutorScheduleForm.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const TutorScheduleForm = ({ isEdit }) => {
    const navigate = useNavigate();
    const { scheduleId } = useParams();
    const [schedule, setSchedule] = useState([]);
    const [tutorId, setTutorId] = useState('');

    useEffect(() => {
        if (isEdit) {
            fetchSchedule();
        }
    }, []);

    const fetchSchedule = async () => {
        try {
            const response = await axios.get(`/api/tutor-schedules/${scheduleId}`);
            setSchedule(response.data.schedule);
            setTutorId(response.data.tutor.id);
        } catch (error) {
            console.error("Error fetching schedule:", error);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const tutorSchedule = { tutor: { id: tutorId }, schedule };

        try {
            if (isEdit) {
                await axios.put(`/api/tutor-schedules/update/${scheduleId}`, tutorSchedule);
            } else {
                await axios.post('/api/tutor-schedules/create', tutorSchedule);
            }
            navigate('/');
        } catch (error) {
            console.error("Error saving schedule:", error);
        }
    };

    return (
        <div>
            <h2>{isEdit ? "Edit" : "Create"} Tutor Schedule</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Tutor ID:
                    <input type="text" value={tutorId} onChange={(e) => setTutorId(e.target.value)} required />
                </label>
                <label>
                    Schedule:
                    <textarea
                        value={schedule.join('\n')}
                        onChange={(e) => setSchedule(e.target.value.split('\n'))}
                        placeholder="Enter time slots, one per line"
                    />
                </label>
                <button type="submit">Save</button>
            </form>
        </div>
    );
};

export default TutorScheduleForm;
