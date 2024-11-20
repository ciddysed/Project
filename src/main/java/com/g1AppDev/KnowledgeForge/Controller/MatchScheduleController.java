package com.g1AppDev.KnowledgeForge.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g1AppDev.KnowledgeForge.Entity.MatchSchedule;
import com.g1AppDev.KnowledgeForge.Service.MatchScheduleService;


@RequestMapping("/api/match-schedules")
@RestController
public class MatchScheduleController {
    private final MatchScheduleService matchScheduleService;
  
    @Autowired
    public MatchScheduleController(MatchScheduleService matchScheduleService) {
        this.matchScheduleService = matchScheduleService;
}   
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