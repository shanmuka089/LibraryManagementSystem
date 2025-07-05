package com.management.library.inventory;

import com.management.library.entity.BookCopy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryInventoryImpl implements InventorySupport
{
    protected Map<String, List<BookCopy>> inventoryBooks;
    
    public LibraryInventoryImpl()
    {
        this.inventoryBooks = new HashMap<>();
    }
    
    public void addBookCopy(String ISBN, BookCopy bookCopy)
    {
        this.inventoryBooks.computeIfAbsent(ISBN, k -> new java.util.ArrayList<>()).add(bookCopy);
    }

    @Override
    public void updateBookCopy(String isbn, BookCopy bookCopy)
    {
        List<BookCopy> copies = this.inventoryBooks.get(isbn);
        if (copies != null) {
            for (int i = 0; i < copies.size(); i++) {
                if (copies.get(i).getCopyId().equals(bookCopy.getCopyId())) {
                    copies.set(i, bookCopy);
                    return;
                }
            }
        }
        addBookCopy(isbn, bookCopy);
    }

    public boolean removeBookCopy(String ISBN, BookCopy bookCopy)
    {
        List<BookCopy> copies = this.inventoryBooks.get(ISBN);
        if (copies != null) {
            if(copies.isEmpty()) {
                this.inventoryBooks.remove(ISBN);
                return false;
            }
            return copies.remove(bookCopy);
        }
        return false;
    }

    public List<BookCopy> getBookCopies(String ISBN)
    {
        return this.inventoryBooks.getOrDefault(ISBN, new java.util.ArrayList<>());
    }
    
    public List<BookCopy> getAllBookCopies()
    {
        return this.inventoryBooks.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public boolean isBookAvailable(String ISBN)
    {
        List<BookCopy> copies = this.inventoryBooks.get(ISBN);
        return copies != null && !copies.isEmpty();
    }

    public BookCopy getBookCopy(String ISBN)
    {
        List<BookCopy> copies = this.inventoryBooks.get(ISBN);
        if (copies != null && !copies.isEmpty()) {
            BookCopy bookCopy =  copies.get(0);
            removeBookCopy(ISBN, bookCopy);
            return bookCopy;
        }
        return null;
    }
}
