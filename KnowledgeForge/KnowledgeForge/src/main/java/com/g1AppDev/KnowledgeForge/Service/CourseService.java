package com.g1AppDev.KnowledgeForge.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g1AppDev.KnowledgeForge.Entity.Course;
import com.g1AppDev.KnowledgeForge.Repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course saveDetails(Course course) {
        return courseRepository.save(course);
    }
}