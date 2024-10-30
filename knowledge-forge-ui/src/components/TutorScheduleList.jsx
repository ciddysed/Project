// src/pages/TutorScheduleList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const TutorScheduleList = () => {
    const [schedules, setSchedules] = useState([]);

    useEffect(() => {
        fetchSchedules();
    }, []);

    const fetchSchedules = async () => {
        try {
            const response = await axios.get('/api/tutor-schedules');
            setSchedules(response.data);
        } catch (error) {
            console.error("Error fetching schedules:", error);
        }
    };

    const deleteSchedule = async (id) => {
        try {
            await axios.delete(`/api/tutor-schedules/delete/${id}`);
            setSchedules(schedules.filter(schedule => schedule.tutorSchedId !== id));
        } catch (error) {
            console.error("Error deleting schedule:", error);
        }
    };

    return (
        <div>
            <h1>Tutor Schedules</h1>
            <Link to="/tutor-schedules/create">Create New Schedule</Link>
            <ul>
                {schedules.map(schedule => (
                    <li key={schedule.tutorSchedId}>
                        {`Schedule ID: ${schedule.tutorSchedId}, Tutor ID: ${schedule.tutor.id}`}
                        <Link to={`/tutor-schedules/${schedule.tutorSchedId}`}>View</Link>
                        <Link to={`/tutor-schedules/update/${schedule.tutorSchedId}`}>Edit</Link>
                        <button onClick={() => deleteSchedule(schedule.tutorSchedId)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TutorScheduleList;
