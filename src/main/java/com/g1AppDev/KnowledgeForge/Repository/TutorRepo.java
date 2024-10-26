package com.g1AppDev.KnowledgeForge.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1AppDev.KnowledgeForge.Entity.Tutor;


@Repository
public interface TutorRepo extends JpaRepository<Tutor, Integer> {
    // You can add custom query methods if needed
}
