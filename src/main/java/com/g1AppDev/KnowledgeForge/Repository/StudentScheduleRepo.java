package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1AppDev.KnowledgeForge.Entity.StudentSchedule;

public interface StudentScheduleRepo extends JpaRepository<StudentSchedule, Integer>{

}