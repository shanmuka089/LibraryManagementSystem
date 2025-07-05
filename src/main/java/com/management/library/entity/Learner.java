package com.management.library.entity;

import com.management.library.observer.BookObserver;

public class Learner implements BookObserver
{
    private String id;
    private String name;
    
    public Learner(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public void notify(String message)
    {
        System.out.println("Patron notified: " + message);
    }

}
