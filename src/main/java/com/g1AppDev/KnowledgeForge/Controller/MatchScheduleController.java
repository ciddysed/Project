package com.g1AppDev.KnowledgeForge.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.g1AppDev.KnowledgeForge.Entity.MatchSchedule;
import com.g1AppDev.KnowledgeForge.Service.MatchScheduleService;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/match-schedules")
@RestController
public class MatchScheduleController {
    private final MatchScheduleService matchScheduleService;
  

    // Get Match Schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<MatchSchedule> getMatchScheduleById(@PathVariable int id) {
        Optional<MatchSchedule> matchSchedule = matchScheduleService.findMatchScheduleById(id);
        return matchSchedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get All Match Schedules
    @GetMapping
    public ResponseEntity<List<MatchSchedule>> getAllMatchSchedules() {
        List<MatchSchedule> matchSchedules = matchScheduleService.findAllMatchSchedules();
        return ResponseEntity.ok(matchSchedules);
    }

    
}