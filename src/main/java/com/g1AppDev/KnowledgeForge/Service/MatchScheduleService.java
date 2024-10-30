package com.g1AppDev.KnowledgeForge.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.g1AppDev.KnowledgeForge.Entity.MatchSchedule;
import com.g1AppDev.KnowledgeForge.Repository.MatchScheduleRepo;
public class MatchScheduleService {
    private final MatchScheduleRepo matchScheduleRepository;

    @Autowired
    public ModuleService(MatchScheduleRepo matchScheduleRepository) {
        this.matchScheduleRepository = matchScheduleRepository;
    }

    public Optional<MatchSchedule> findModuleById(int id) {
        return matchScheduleRepository.findById(id);
    }

    public List<MatchSchedule> findAllModules() {
        return matchScheduleRepository.findAll();
        
    }

    public MatchSchedule createMatchSchedule(TutorSchedule tutorSchedule, StudentSchedule studentSchedule) {
        MatchSchedule matchSchedule = new MatchSchedule();
        matchSchedule.setTutorSchedule(tutorSchedule);
        matchSchedule.setStudentSchedule(studentSchedule);
        return matchScheduleRepository.save(matchSchedule);
    }

    public boolean isMatched(MatchSchedule matchSchedule) {
        return matchSchedule.getTutorSchedule().getId().equals(matchSchedule.getStudentSchedule().getId());
    }
}