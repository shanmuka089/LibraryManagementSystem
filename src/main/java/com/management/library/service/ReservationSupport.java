package com.management.library.service;

import com.management.library.entity.Learner;

public interface ReservationSupport
{
    void reserve(String copyId, Learner learner);
    void cancelReservation(String copyId, Learner learner);
    void notifyReservation(String copyId);
}
