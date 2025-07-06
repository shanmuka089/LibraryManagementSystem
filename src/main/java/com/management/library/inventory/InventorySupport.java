package com.management.library.inventory;

import com.management.library.entity.BookCopy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface InventorySupport
{
    void addBookCopy(String isbn, BookCopy bookCopy);
    void updateBookCopy(String isbn, BookCopy bookCopy);
    boolean removeBookCopy(String isbn, BookCopy bookCopy);
    Set<BookCopy> getBookCopies(String isbn);
    boolean isBookAvailable(String isbn);
    BookCopy getBookCopy(String isbn);
    Set<BookCopy> getAllBookCopies();
    
}
