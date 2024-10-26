package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.g1AppDev.KnowledgeForge.Entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    
}