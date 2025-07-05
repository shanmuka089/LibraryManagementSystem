package com.management.library.entity;

public class BookCopy
{
    private String copyId;
    private Book book;
    
    public BookCopy()
    {
    }
    public BookCopy(String copyId, Book book)
    {
        this.copyId = copyId;
        this.book = book;
    }
    public String getCopyId()
    {
        return copyId;
    }
    
    public void setCopyId(String copyId)
    {
        this.copyId = copyId;
    }
    
    public Book getBook()
    {
        return book;
    }
    public void setBook(Book book)
    {
        this.book = book;
    }
}
