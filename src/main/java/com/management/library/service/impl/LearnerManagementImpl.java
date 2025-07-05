package com.management.library.service.impl;

import com.management.library.entity.Learner;
import com.management.library.service.LearnerManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearnerManagementImpl implements LearnerManagement
{

    Map<String, Learner> learners;
    
    public LearnerManagementImpl() {
        this.learners = new HashMap<>();
    }
    
    @Override
    public void addLearner(String learnerId, Learner learner)
    {
        learners.put(learnerId, learner);
        System.out.println("Learner with ID " + learnerId + " has been added.");
    }

    @Override
    public void removeLearner(String learnerId)
    {
        if (learners.containsKey(learnerId)) {
            learners.remove(learnerId);
            System.out.println("Learner with ID " + learnerId + " has been removed.");
        } else {
            System.out.println("Learner with ID " + learnerId + " does not exist.");
        }
    }

    @Override
    public void updateLearner(String learnerId, Learner learner)
    {
        if (learners.containsKey(learnerId)) {
            learners.put(learnerId, learner);
            System.out.println("Learner with ID " + learnerId + " has been updated.");
        } else {
            System.out.println("Learner with ID " + learnerId + " does not exist.");
        }
    }
    
    @Override
    public Learner getLearner(String learnerId)
    {
        if (learners.containsKey(learnerId)) {
            return learners.get(learnerId);
        } else {
            System.out.println("Learner with ID " + learnerId + " does not exist.");
            return null;
        }
    }
    
    @Override
    public List<Learner> getAllLearners()
    {
        return List.copyOf(learners.values());
    }

}
