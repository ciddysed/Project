package com.g1AppDev.KnowledgeForge.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1AppDev.KnowledgeForge.Entity.TutorSchedule;
import com.g1AppDev.KnowledgeForge.Repository.TutorScheduleRepo;

@Service
public class TutorScheduleService {
    private final TutorScheduleRepo tutorScheduleRepo;

    @Autowired
    public TutorScheduleService(TutorScheduleRepo tutorScheduleRepo) {
        this.tutorScheduleRepo = tutorScheduleRepo;
    }

    // Create TutorSchedule with selected schedule slots
    public TutorSchedule createTutorSchedule(TutorSchedule tutorSchedule) {
        if (tutorSchedule.getSchedule() == null || tutorSchedule.getSchedule().isEmpty()) {
            tutorSchedule.setSchedule(TutorSchedule.DEFAULT_SCHEDULE); // Optional: set default if needed
        }
        return tutorScheduleRepo.save(tutorSchedule);
    }

    // Retrieve TutorSchedule by ID
    public Optional<TutorSchedule> findTutorScheduleById(int scheduleId) {
        return tutorScheduleRepo.findById(scheduleId);
    }

   // Update TutorSchedule by ID with selected schedule slots
   public Optional<TutorSchedule> updateTutorSchedule(int scheduleId, TutorSchedule updatedTutorSchedule) {
    return tutorScheduleRepo.findById(scheduleId).map(existingSchedule -> {
        existingSchedule.setSchedule(updatedTutorSchedule.getSchedule());
        return tutorScheduleRepo.save(existingSchedule);
    });
}

    public boolean deleteTutorSchedule(int scheduleId) {
        if (tutorScheduleRepo.existsById(scheduleId)) {
            tutorScheduleRepo.deleteById(scheduleId);
            return true;
        }
        return false;
    }
}