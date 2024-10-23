package com.g1AppDev.KnowledgeForge.Repository;

import org.springframework.data.repository.CrudRepository;
import com.g1AppDev.KnowledgeForge.Entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    
}