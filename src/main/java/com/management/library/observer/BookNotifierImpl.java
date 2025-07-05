package com.management.library.observer;

import java.util.List;
import java.util.Map;

public class BookNotifierImpl implements BookNotifier
{
    Map<String, List<BookObserver>> observersMap;
    
    public BookNotifierImpl() {
        observersMap = new java.util.HashMap<>();
    }
    
    @Override
    public void addObserver(String isbn, BookObserver observer) {
        if (isbn == null || observer == null) {
            throw new IllegalArgumentException("ISBN and observer cannot be null");
        }
        observersMap.computeIfAbsent(isbn, k -> new java.util.ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(String isbn) 
    {
        observersMap.remove(isbn);
    }
    

    @Override
    public void notifyObservers(String isbn)
    {
        if (!observersMap.containsKey(isbn)) {
            System.out.println("No observers for book with isbn: " + isbn);
            return;
        }
        observersMap.get(isbn).forEach(observer -> observer.notify("Book with isbn " + isbn + " is now available."));
    }
    

}
