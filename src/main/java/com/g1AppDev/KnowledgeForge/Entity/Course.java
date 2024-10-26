package com.g1AppDev.KnowledgeForge.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")  // Column label for the primary key
    private int courseID;

    @Column(name = "course_name", nullable = false)  // Non-nullable column
    private String courseName;

    // Many courses are taught by one tutor
    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)  // Foreign key column
    private Tutor tutor;

    // Constructors
    public Course() {
    }

    public Course(String courseName, Tutor tutor) {
        this.courseName = courseName;
        this.tutor = tutor;
    }

    // Getters and Setters
    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}