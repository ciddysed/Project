// src/pages/TutorScheduleDetail.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const TutorScheduleDetail = () => {
    const { scheduleId } = useParams();
    const [schedule, setSchedule] = useState(null);

    useEffect(() => {
        fetchSchedule();
    }, []);

    const fetchSchedule = async () => {
        try {
            const response = await axios.get(`/api/tutor-schedules/${scheduleId}`);
            setSchedule(response.data);
        } catch (error) {
            console.error("Error fetching schedule:", error);
        }
    };

    if (!schedule) return <div>Loading...</div>;

    return (
        <div>
            <h2>Tutor Schedule Details</h2>
            <p>Schedule ID: {schedule.tutorSchedId}</p>
            <p>Tutor ID: {schedule.tutor.id}</p>
            <p>Schedule:</p>
            <ul>
                {schedule.schedule.map((timeSlot, index) => (
                    <li key={index}>{timeSlot}</li>
                ))}
            </ul>
        </div>
    );
};

export default TutorScheduleDetail;
