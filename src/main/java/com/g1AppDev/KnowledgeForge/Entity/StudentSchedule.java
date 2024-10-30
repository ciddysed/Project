package com.g1AppDev.KnowledgeForge.Entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class StudentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_sched_id")
    private int studentSchedId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ElementCollection
    @CollectionTable(name = "schedule", joinColumns = @JoinColumn(name = "student_sched_id"))
    @Column(name = "time_slot")
    private List<String> schedule;

    // Default time slots for MWF and TTHS
    public static final List<String> DEFAULT_SCHEDULE = List.of(
            "MWF 7:30 - 10:30", "MWF 11:30 - 14:30", "MWF 15:30 - 16:30",
            "TTHS 7:30 - 10:30", "TTHS 11:30 - 14:30", "TTHS 15:30 - 16:30"
    );

    // Getters and Setters

    public int getStudentSchedId() {
        return studentSchedId;
    }

    public void setStudentSchedId(int studentSchedId) {
        this.studentSchedId = studentSchedId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }
}