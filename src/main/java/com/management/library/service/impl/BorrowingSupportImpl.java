package com.management.library.service.impl;

import com.management.library.entity.BookCopy;
import com.management.library.entity.BorrowStatus;
import com.management.library.entity.BorrowedBook;
import com.management.library.entity.Learner;
import com.management.library.inventory.InventorySupport;
import com.management.library.observer.BookNotifier;
import com.management.library.service.BorrowingSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BorrowingSupportImpl implements BorrowingSupport
{
    
    Map<String, List<BorrowedBook>> learnerBorrowHistory;
    BookNotifier bookNotifier;
    public BorrowingSupportImpl(BookNotifier bookNotifier) {
        this.bookNotifier = bookNotifier;
        this.learnerBorrowHistory = new java.util.HashMap<>();
    }
    
    @Override
    public void checkOut(BookCopy bookCopy, Learner learner, InventorySupport inventorySupport)
    {
        
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setLearnerId(learner.getId());
        borrowedBook.setStatus(BorrowStatus.BORROWED);
        borrowedBook.setBookCopy(bookCopy);
        borrowedBook.setBorrowedDate(new Date());
        borrowedBook.setLearnerName(learner.getName());
        borrowedBook.setDueDate(new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000));
        boolean isBookFound = inventorySupport.removeBookCopy(bookCopy.getBook().getIsbn(), bookCopy);
        if (!isBookFound) {
            System.out.println("Book is out of stock or not available for borrowing, please reserve the book");
            return;
        }
        learnerBorrowHistory.computeIfAbsent(learner.getId(), k -> new java.util.ArrayList<>()).add(borrowedBook);
        System.out.println("Book borrowed successfully by " + learner.getName() + ". Copy ID: " + bookCopy.getCopyId());
    }

    
    @Override
    public void returnCopy(BookCopy copy, Learner learner, InventorySupport inventorySupport)
    {
        learnerBorrowHistory.get(learner.getId()).stream()
                .filter(borrowedBook -> borrowedBook.getBookCopy().getCopyId().equals(copy.getCopyId()) && borrowedBook.getStatus() == BorrowStatus.BORROWED)
                .findFirst()
                .ifPresent(borrowedBook -> {
                borrowedBook.setStatus(BorrowStatus.RETURNED);
                borrowedBook.setReturnedDate(new Date());
                    inventorySupport.addBookCopy(borrowedBook.getBookCopy().getBook().getIsbn(), borrowedBook.getBookCopy());
                });
        System.out.println("Book returned successfully by " + learner.getName() + ". Copy ID: " + copy.getCopyId());
        bookNotifier.notifyObservers(copy.getBook().getIsbn());
    }

    @Override
    public List<BorrowedBook> getLearnerBorrowHistory(String learnerId)
    {
        System.out.println("Fetching borrow history for learner ID: " + learnerId);
        return learnerBorrowHistory.get(learnerId);
    }

}
