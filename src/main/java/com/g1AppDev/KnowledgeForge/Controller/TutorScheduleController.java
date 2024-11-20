package com.g1AppDev.KnowledgeForge.Controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g1AppDev.KnowledgeForge.Entity.TutorSchedule;
import com.g1AppDev.KnowledgeForge.Service.TutorScheduleService;

@RestController
@RequestMapping("/api/tutor-schedules")
public class TutorScheduleController {
    @Autowired
    private final TutorScheduleService tutorScheduleService;

    
    public TutorScheduleController(TutorScheduleService tutorScheduleService) {
        this.tutorScheduleService = tutorScheduleService;
    }

    // Create TutorSchedule
    @PostMapping("/create")
    public ResponseEntity<TutorSchedule> createTutorSchedule(@RequestBody TutorSchedule tutorSchedule) {
        tutorSchedule.setSchedule(tutorSchedule.getSchedule());
        TutorSchedule createdSchedule = tutorScheduleService.createTutorSchedule(tutorSchedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }
    // Get TutorSchedule by ID
    @GetMapping("/{scheduleId}")
    public ResponseEntity<TutorSchedule> getTutorScheduleById(@PathVariable int scheduleId) {
        Optional<TutorSchedule> tutorSchedule = tutorScheduleService.findTutorScheduleById(scheduleId);
        return tutorSchedule.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

     // Update TutorSchedule by ID
    @PutMapping("/update/{scheduleId}")
    public ResponseEntity<TutorSchedule> updateTutorSchedule(@PathVariable int scheduleId, @RequestBody TutorSchedule updatedTutorSchedule) {
        return tutorScheduleService.updateTutorSchedule(scheduleId, updatedTutorSchedule)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete TutorSchedule by ID
    @DeleteMapping("/delete/{scheduleId}")
    public ResponseEntity<Void> deleteTutorSchedule(@PathVariable int scheduleId) {
        if (tutorScheduleService.deleteTutorSchedule(scheduleId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}