package com.management.library.entity;

public class Book
{

    private String title;
    private String author;
    private String isbn;
    private String publicationYear;
    
    public Book()
    {
    }
    public Book(String title, String author, String isbn, String publicationYear)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    public String getPublicationYear()
    {
        return publicationYear;
    }
    public void setPublicationYear(String publicationYear)
    {
        this.publicationYear = publicationYear;
    }
    
    @Override
    public String toString()
    {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", publicationYear=" + publicationYear
                + "]";
    }
}
