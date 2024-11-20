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

import com.g1AppDev.KnowledgeForge.Entity.StudentSchedule;
import com.g1AppDev.KnowledgeForge.Service.StudentScheduleService;

@RestController
@RequestMapping("/api/student-schedules")
public class StudentScheduleController {
    @Autowired
    private final StudentScheduleService studentScheduleService;

    
    public StudentScheduleController(StudentScheduleService studentScheduleService) {
        this.studentScheduleService = studentScheduleService;
    }

    // Create StudentSchedule with selected schedule slots
    @PostMapping("/create")
    public ResponseEntity<StudentSchedule> createStudentSchedule(@RequestBody StudentSchedule studentSchedule) {
        StudentSchedule createdSchedule = studentScheduleService.createStudentSchedule(studentSchedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    // Get StudentSchedule by ID
    @GetMapping("/{scheduleId}")
    public ResponseEntity<StudentSchedule> getStudentScheduleById(@PathVariable int scheduleId) {
        Optional<StudentSchedule> studentSchedule = studentScheduleService.findStudentScheduleById(scheduleId);
        return studentSchedule.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update StudentSchedule by ID
    @PutMapping("/update/{scheduleId}")
    public ResponseEntity<StudentSchedule> updateStudentSchedule(@PathVariable int scheduleId, @RequestBody StudentSchedule updatedStudentSchedule) {
        return studentScheduleService.updateStudentSchedule(scheduleId, updatedStudentSchedule)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete StudentSchedule by ID
    @DeleteMapping("/delete/{scheduleId}")
    public ResponseEntity<Void> deleteStudentSchedule(@PathVariable int scheduleId) {
        if (studentScheduleService.deleteStudentSchedule(scheduleId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
