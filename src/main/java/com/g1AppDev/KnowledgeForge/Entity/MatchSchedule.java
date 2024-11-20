package com.g1AppDev.KnowledgeForge.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MatchSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int matchId;

    @ManyToOne
    @JoinColumn(name = "tutor_sched_id", nullable = false, referencedColumnName = "id")
    private TutorSchedule tutorSchedule;

    @ManyToOne
    @JoinColumn(name = "student_sched_id", nullable = false, referencedColumnName = "id")
    private StudentSchedule studentSchedule;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public TutorSchedule getTutorSchedule() {
        return tutorSchedule;
    }

    public void setTutorSchedule(TutorSchedule tutorSchedule) {
        this.tutorSchedule = tutorSchedule;
    }

    public StudentSchedule getStudentSchedule() {
        return studentSchedule;
    }


    public void setStudentSchedule(StudentSchedule studentSchedule) {
        this.studentSchedule = studentSchedule;
    }

    
}