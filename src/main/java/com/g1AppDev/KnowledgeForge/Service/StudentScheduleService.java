package com.g1AppDev.KnowledgeForge.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1AppDev.KnowledgeForge.Entity.StudentSchedule;
import com.g1AppDev.KnowledgeForge.Repository.StudentScheduleRepo;

@Service
public class StudentScheduleService {
    @Autowired
    private final StudentScheduleRepo studentScheduleRepository;

    
    public StudentScheduleService(StudentScheduleRepo studentScheduleRepository) {
        this.studentScheduleRepository = studentScheduleRepository;
    }

    // Create StudentSchedule with selected schedule slots
    public StudentSchedule createStudentSchedule(StudentSchedule studentSchedule) {
        if (studentSchedule.getSchedule() == null || studentSchedule.getSchedule().isEmpty()) {
            studentSchedule.setSchedule(StudentSchedule.DEFAULT_SCHEDULE); // Optional: set default if needed
        }
        return studentScheduleRepository.save(studentSchedule);
    }

    // Update StudentSchedule by ID with selected schedule slots
    public Optional<StudentSchedule> updateStudentSchedule(int scheduleId, StudentSchedule updatedStudentSchedule) {
        return studentScheduleRepository.findById(scheduleId).map(existingSchedule -> {
            existingSchedule.setSchedule(updatedStudentSchedule.getSchedule());
            return studentScheduleRepository.save(existingSchedule);
        });
    }

    // Find StudentSchedule by ID
    public Optional<StudentSchedule> findStudentScheduleById(int scheduleId) {
        return studentScheduleRepository.findById(scheduleId);
    }

    // Delete StudentSchedule by ID
    public boolean deleteStudentSchedule(int scheduleId) {
        if (studentScheduleRepository.existsById(scheduleId)) {
            studentScheduleRepository.deleteById(scheduleId);
            return true;
        }
        return false;
    }
}