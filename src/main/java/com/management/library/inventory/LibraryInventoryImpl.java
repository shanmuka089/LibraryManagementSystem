package com.management.library.inventory;

import com.management.library.entity.BookCopy;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryInventoryImpl implements InventorySupport
{
    protected Map<String, Set<BookCopy>> inventoryBooks;
    
    public LibraryInventoryImpl()
    {
        this.inventoryBooks = new HashMap<>();
    }
    
    public void addBookCopy(String ISBN, BookCopy bookCopy)
    {
        this.inventoryBooks.computeIfAbsent(ISBN, k -> new HashSet<>()).add(bookCopy);
    }

    @Override
    public void updateBookCopy(String isbn, BookCopy bookCopy)
    {
        Set<BookCopy> copies = this.inventoryBooks.get(isbn);
        if (copies != null) {

            copies.stream().filter(c -> c.getCopyId().equals(bookCopy.getCopyId()))
                    .findFirst()
                    .ifPresent(existingCopy -> {
                        copies.remove(existingCopy);
                        copies.add(bookCopy);
                    });
        }
        addBookCopy(isbn, bookCopy);
    }

    public boolean removeBookCopy(String ISBN, BookCopy bookCopy)
    {
        Set<BookCopy> copies = this.inventoryBooks.get(ISBN);
        if (copies != null) {
            if(copies.isEmpty()) {
                this.inventoryBooks.remove(ISBN);
                return false;
            }
            return copies.remove(bookCopy);
        }
        return false;
    }

    public Set<BookCopy> getBookCopies(String ISBN)
    {
        return this.inventoryBooks.getOrDefault(ISBN, new HashSet<>());
    }
    
    public Set<BookCopy> getAllBookCopies()
    {
        return this.inventoryBooks.values().stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public boolean isBookAvailable(String ISBN)
    {
        Set<BookCopy> copies = this.inventoryBooks.get(ISBN);
        return copies != null && !copies.isEmpty();
    }

    public BookCopy getBookCopy(String ISBN)
    {
        Set<BookCopy> copies = this.inventoryBooks.get(ISBN);
        if (copies != null && !copies.isEmpty()) {
            BookCopy bookCopy =  copies.iterator().next();
            removeBookCopy(ISBN, bookCopy);
            return bookCopy;
        }
        return null;
    }
}
