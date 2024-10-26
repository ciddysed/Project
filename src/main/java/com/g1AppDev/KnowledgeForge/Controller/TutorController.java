package com.g1AppDev.KnowledgeForge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g1AppDev.KnowledgeForge.Entity.Tutor;
import com.g1AppDev.KnowledgeForge.Service.TutorService;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping("/register")
    public Tutor register(@RequestBody Tutor tutor) {
        return tutorService.registerTutor(tutor.getTutorName(), tutor.getEmail());
    }

    @PostMapping("/login")
    public Tutor login(@RequestParam String email) {
        return tutorService.login(email);
    }
}
