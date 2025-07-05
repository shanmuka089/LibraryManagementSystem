package com.management.library.service.impl;

import com.management.library.entity.Learner;
import com.management.library.observer.BookNotifier;
import com.management.library.service.ReservationSupport;

import java.util.Map;

public class ReservationSupportImpl implements ReservationSupport
{
    private BookNotifier bookNotifier;
    
    public ReservationSupportImpl(BookNotifier bookNotifier) {
        this.bookNotifier = bookNotifier;
    }


    @Override
    public void reserve(String isbn, Learner learner)
    {
        bookNotifier.addObserver(isbn, learner);
        System.out.println("Reservation made for copy ID: " + isbn + " by learner: " + learner.getName());
    }

    @Override
    public void cancelReservation(String isbn, Learner learner)
    {
        bookNotifier.removeObserver(isbn);
        System.out.println("Reservation cancelled for copy ID: " + isbn + " by learner: " + learner.getName());
    }

    @Override
    public void notifyReservation(String copyId)
    {
        bookNotifier.notifyObservers(copyId);
        System.out.println("Notification sent for copy ID: " + copyId + " to learners");
    }

}
