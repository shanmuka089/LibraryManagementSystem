package com.management.library.branch.spec;

import com.management.library.entity.BookCopy;
import com.management.library.entity.BorrowedBook;
import com.management.library.entity.Learner;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;
import com.management.library.observer.BookNotifier;
import com.management.library.service.BorrowingSupport;
import com.management.library.service.ReservationSupport;
import com.management.library.service.SearchSupport;

import java.util.List;

public abstract class LibraryBranch
{
    protected String branchId;
    protected String address;
    protected InventorySupport inventorySupport;  
    protected BorrowingSupport borrowingSupport;
    protected SearchSupport searchSupport;
    protected ReservationSupport reservationSupport;
    
    public LibraryBranch(String branchId, String address, InventorySupport inventorySupport,
                         BorrowingSupport borrowingSupport, SearchSupport searchSupport,
                         ReservationSupport reservationSupport) {
        this.branchId = branchId;
        this.address = address;
        this.inventorySupport = inventorySupport;
        this.borrowingSupport = borrowingSupport;
        this.searchSupport = searchSupport;
        this.reservationSupport = reservationSupport;
    }
    
    public abstract void addBook(BookCopy bookCopy);
    public abstract void removeBook(BookCopy bookCopy);
    public abstract void updateBook(BookCopy bookCopy);
    public abstract List<BookCopy> searchBook(SearchQuery searchQuery);
    public abstract void checkOutBook(BookCopy copy, Learner learner);
    public abstract void returnBook(BookCopy copy, Learner learner);
    public abstract void reserveBook(String isbn, Learner learner);
    public abstract void cancelReservation(String isbn, Learner learner);
    public abstract List<BorrowedBook> getLearnerBorrowHistory(String learnerId);
    
}
