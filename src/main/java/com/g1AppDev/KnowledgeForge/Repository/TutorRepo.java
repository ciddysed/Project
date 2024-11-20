package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1AppDev.KnowledgeForge.Entity.Tutor;

public interface TutorRepo extends JpaRepository<Tutor, Integer> {
    Tutor findByEmail(String email);
    
}
