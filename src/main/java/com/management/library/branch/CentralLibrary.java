package com.management.library.branch;

import com.management.library.branch.spec.LibraryBranch;
import com.management.library.entity.BookCopy;
import com.management.library.entity.BorrowedBook;
import com.management.library.entity.Learner;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;
import com.management.library.service.BorrowingSupport;
import com.management.library.service.ReservationSupport;
import com.management.library.service.SearchSupport;

import java.util.List;

public class CentralLibrary extends LibraryBranch
{
    public CentralLibrary(String branchId, String address, InventorySupport inventorySupport,
                          BorrowingSupport borrowingSupport, SearchSupport searchSupport,
                          ReservationSupport reservationSupport) {
        super(branchId, address, inventorySupport, borrowingSupport, searchSupport, reservationSupport);
    }

    @Override
    public void addBook(BookCopy bookCopy)
    {
        verifyInventory();
        inventorySupport.addBookCopy(bookCopy.getBook().getIsbn(), bookCopy);
    }

    @Override
    public void removeBook(BookCopy bookCopy)
    {
        verifyInventory();
        inventorySupport.removeBookCopy(bookCopy.getBook().getIsbn(), bookCopy);
    }

    @Override
    public void updateBook(BookCopy bookCopy)
    {
        verifyInventory();
        inventorySupport.updateBookCopy(bookCopy.getBook().getIsbn(), bookCopy);
    }

    @Override
    public List<BookCopy> searchBook(SearchQuery searchQuery)
    {
        verifySearch();
        return searchSupport.search(searchQuery, inventorySupport);
    }

    @Override
    public void checkOutBook(BookCopy copy, Learner learner)
    {
        verifyBorrowing();
        borrowingSupport.checkOut(copy, learner, inventorySupport);
    }

    @Override
    public void returnBook(BookCopy copy, Learner learner)
    {
        verifyBorrowing();
        borrowingSupport.returnCopy(copy, learner, inventorySupport);
    }

    @Override
    public void reserveBook(String isbn, Learner learner)
    {
        verifyReservation();
        reservationSupport.reserve(isbn, learner);
    }

    @Override
    public void cancelReservation(String isbn, Learner learner)
    {
        verifyReservation();
        reservationSupport.cancelReservation(isbn, learner);
    }
    
    @Override
    public List<BorrowedBook> getLearnerBorrowHistory(String learnerId)
    {
        verifyBorrowing();
        return borrowingSupport.getLearnerBorrowHistory(learnerId);
    }

    private void verifyInventory() {
        if(inventorySupport == null) System.out.println("Not supporting Inventory.");
    }
    
    private void verifyBorrowing() {
        if(borrowingSupport == null) System.out.println("Not supporting Borrowing.");
    }
    private void verifySearch() {
        if(searchSupport == null) System.out.println("Not supporting Search.");
    }
   private void verifyReservation() {
        if(reservationSupport == null) System.out.println("Not supporting Reservation.");
    }
    
    public static LibraryBranchBuilder builder()
    {
        return new LibraryBranchBuilder();
    }
    public static class LibraryBranchBuilder
    {
        private String branchId;
        private String address;

        private InventorySupport inventorySupport;
        private BorrowingSupport borrowingSupport;
        private SearchSupport searchSupport;
        private ReservationSupport reservationSupport;

        public LibraryBranchBuilder setBranchId(String branchId)
        {
            this.branchId = branchId;
            return this;
        }

        public LibraryBranchBuilder setAddress(String address)
        {
            this.address = address;
            return this;
        }

        public LibraryBranchBuilder setInventorySupport(InventorySupport inventorySupport)
        {
            this.inventorySupport = inventorySupport;
            return this;
        }
        public LibraryBranchBuilder setBorrowingSupport(BorrowingSupport borrowingSupport)
        {
            this.borrowingSupport = borrowingSupport;
            return this;
        }
        public LibraryBranchBuilder setSearchSupport(SearchSupport searchSupport)
        {
            this.searchSupport = searchSupport;
            return this;
        }
        public LibraryBranchBuilder setReservationSupport(ReservationSupport reservationSupport)
        {
            this.reservationSupport = reservationSupport;
            return this;
        }
        public CentralLibrary build()
        {
            return new CentralLibrary(branchId, address, inventorySupport, borrowingSupport, searchSupport, reservationSupport);
        }
    }
    
}
