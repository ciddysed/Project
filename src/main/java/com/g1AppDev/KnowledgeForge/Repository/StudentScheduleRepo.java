package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1AppDev.KnowledgeForge.Entity.StudentSchedule;

@Repository
public interface StudentScheduleRepo extends JpaRepository<StudentSchedule, Integer>{

}