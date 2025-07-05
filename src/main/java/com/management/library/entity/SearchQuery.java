package com.management.library.entity;

public class SearchQuery
{
    private String title;
    private String author;
    private String isbn;

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    
    private SearchQuery(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String title;
        private String author;
        private String isbn;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public SearchQuery build() {
            return new SearchQuery(title, author, isbn);
        }
    }
}
