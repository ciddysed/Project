package com.g1AppDev.KnowledgeForge.Controller;

import com.g1AppDev.KnowledgeForge.Entity.StudentSchedule;
import com.g1AppDev.KnowledgeForge.Service.StudentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student-schedules")
public class StudentScheduleController {
    private final StudentScheduleService studentScheduleService;

    @Autowired
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
