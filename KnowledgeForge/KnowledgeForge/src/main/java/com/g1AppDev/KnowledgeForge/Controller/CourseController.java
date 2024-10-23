package com.g1AppDev.KnowledgeForge.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.g1AppDev.KnowledgeForge.Entity.Course;
import com.g1AppDev.KnowledgeForge.Service.CourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourse")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/addCourses") 
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveDetails(course);
    }

    // Update course
    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    // Delete course
    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }
}
