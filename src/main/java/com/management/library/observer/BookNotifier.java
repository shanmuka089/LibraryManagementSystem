package com.management.library.observer;

public interface BookNotifier
{
    void addObserver(String isbn, BookObserver observer);
    void removeObserver(String isbn);
    void notifyObservers(String isbn);

}
