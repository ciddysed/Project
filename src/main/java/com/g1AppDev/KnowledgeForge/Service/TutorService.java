package com.g1AppDev.KnowledgeForge.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1AppDev.KnowledgeForge.Entity.Tutor;
import com.g1AppDev.KnowledgeForge.Repository.TutorRepo;

@Service
public class TutorService {

    @Autowired
    private TutorRepo tutorRepository;

    public Tutor registerTutor(String tutorName, String email) {
        Tutor tutor = new Tutor(tutorName, email);
        return tutorRepository.save(tutor);
    }

    public Tutor login(String email) {
        return tutorRepository.findByEmail(email);
    }
}
