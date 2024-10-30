package com.g1AppDev.KnowledgeForge.Entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TutorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_sched_id")
    private int tutorSchedId;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ElementCollection
    @CollectionTable(name = "schedule", joinColumns = @JoinColumn(name = "tutor_sched_id"))
    @Column(name = "time_slot")
    private List<String> schedule;

    // Default time slots for MWF and TTHS
    public static final List<String> DEFAULT_SCHEDULE = List.of(
            "MWF 7:30 - 10:30", "MWF 11:30 - 14:30", "MWF 15:30 - 16:30",
            "TTHS 7:30 - 10:30", "TTHS 11:30 - 14:30", "TTHS 15:30 - 16:30"
    );

    
    public int getTutorSchedId() {
        return tutorSchedId;
    }

    public void setTutorSchedId(int tutorSchedId) {
        this.tutorSchedId = tutorSchedId;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }
}