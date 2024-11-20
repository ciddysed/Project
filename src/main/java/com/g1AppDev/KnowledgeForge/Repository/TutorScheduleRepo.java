package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1AppDev.KnowledgeForge.Entity.TutorSchedule;

@Repository
public interface TutorScheduleRepo extends JpaRepository<TutorSchedule, Integer>{
    TutorSchedule findByTutorId(int id);
    
}