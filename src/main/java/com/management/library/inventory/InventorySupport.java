package com.management.library.inventory;

import com.management.library.entity.BookCopy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InventorySupport
{
    void addBookCopy(String isbn, BookCopy bookCopy);
    void updateBookCopy(String isbn, BookCopy bookCopy);
    boolean removeBookCopy(String isbn, BookCopy bookCopy);
    List<BookCopy> getBookCopies(String isbn);
    boolean isBookAvailable(String isbn);
    BookCopy getBookCopy(String isbn);
    List<BookCopy> getAllBookCopies();
    
}
