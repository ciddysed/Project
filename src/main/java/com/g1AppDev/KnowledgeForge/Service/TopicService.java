package com.g1AppDev.KnowledgeForge.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1AppDev.KnowledgeForge.Entity.Topic;
import com.g1AppDev.KnowledgeForge.Repository.TopicRepo;

@Service
public class TopicService {

    

    @Autowired
    private final TopicRepo topicRepository;
    public TopicService(TopicRepo topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Create
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    // Find by ID
    public Optional<Topic> findTopicById(int id) {
        return topicRepository.findById(id);
    }

    // Find All
    public List<Topic> findAllTopics() {
        return topicRepository.findAll();
    }

    // Update
    public Topic updateTopic(int id, Topic updatedTopic) {
        Optional<Topic> existingTopic = topicRepository.findById(id);
        if (existingTopic.isPresent()) {
            Topic topic = existingTopic.get();
            topic.setTopicName(updatedTopic.getTopicName());
            topic.setDescription(updatedTopic.getDescription());
            return topicRepository.save(topic);
        }
        return null;
    }

    // Delete
    public boolean deleteTopic(int id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
            return true;
        }
        return false;
    }
}