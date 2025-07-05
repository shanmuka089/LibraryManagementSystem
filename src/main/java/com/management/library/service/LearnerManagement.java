package com.management.library.service;

import com.management.library.entity.Learner;

import java.util.List;

public interface LearnerManagement
{
    void addLearner(String learnerId, Learner learner);
    void removeLearner(String learnerId);
    void updateLearner(String learnerId, Learner learner);
    Learner getLearner(String learnerId);
    List<Learner> getAllLearners();
}
