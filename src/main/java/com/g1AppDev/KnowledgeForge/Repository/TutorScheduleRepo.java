package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1AppDev.KnowledgeForge.Entity.TutorSchedule;

public interface TutorScheduleRepo extends JpaRepository<TutorSchedule, Integer>{
    TutorSchedule findByTutorId(int id);
    
}