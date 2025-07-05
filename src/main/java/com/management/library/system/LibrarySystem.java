package com.management.library.system;

import com.management.library.branch.spec.LibraryBranch;
import com.management.library.entity.BookCopy;
import com.management.library.entity.BorrowedBook;
import com.management.library.entity.Learner;
import com.management.library.entity.SearchQuery;
import com.management.library.service.LearnerManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibrarySystem
{

    Map<String, LibraryBranch> libraryBranches;
    LearnerManagement learnerManagement;
    
    public LibrarySystem(LearnerManagement learnerManagement) {
        this.libraryBranches = new HashMap<>();
        this.learnerManagement = learnerManagement;
    }
    
    public void addLibraryBranch(String branchId, LibraryBranch branch) {
        if (branchId == null || branch == null) {
            throw new IllegalArgumentException("Branch ID and branch cannot be null");
        }
        libraryBranches.put(branchId, branch);   
    }
    
    public LibraryBranch getLibraryBranch(String branchId) {
        if (branchId == null) {
            throw new IllegalArgumentException("Branch ID cannot be null");
        }
        return libraryBranches.get(branchId);
    }
    
    public List<LibraryBranch> getAllLibraryBranches() {
        return List.copyOf(libraryBranches.values());
    }
    
    public void addLearner(Learner learner) {
        if (learner == null || learner.getId() == null) {
            throw new IllegalArgumentException("Learner and Learner ID cannot be null");
        }
        learnerManagement.addLearner(learner.getId(), learner);
    }
    
    public void removeLearner(String learnerId) {
        if (learnerId == null) {
            throw new IllegalArgumentException("Learner ID cannot be null");
        }
        learnerManagement.removeLearner(learnerId);
    }
    
    public Learner getLearner(String learnerId) {
        if (learnerId == null) {
            throw new IllegalArgumentException("Learner ID cannot be null");
        }
        return learnerManagement.getLearner(learnerId);
    }
    
    public List<Learner> getAllLearners() {
        return learnerManagement.getAllLearners();
    }
    
    public void updateLearner(Learner learner) {
        if (learner == null || learner.getId() == null) {
            throw new IllegalArgumentException("Learner and Learner ID cannot be null");
        }
        learnerManagement.updateLearner(learner.getId(), learner);
    }
    
    public void addBook(String branchId, BookCopy bookCopy) {
        if (branchId == null || bookCopy == null) {
            throw new IllegalArgumentException("Branch ID, Book ID, and Book Title cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.addBook(bookCopy);
    }
    
    public void removeBook(String branchId, BookCopy bookCopy) {
        if (branchId == null || bookCopy == null) {
            throw new IllegalArgumentException("Branch ID and Book copy cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.removeBook(bookCopy);
    }
    
    public List<BorrowedBook> getLearnerBorrowHistory(String branchId, String learnerId) {
        if (branchId == null || learnerId == null) {
            throw new IllegalArgumentException("Branch ID and Learner ID cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        return branch.getLearnerBorrowHistory(learnerId);
    }
    
    public void updateBook(String branchId, BookCopy bookCopy) {
        if (branchId == null || bookCopy == null) {
            throw new IllegalArgumentException("Branch ID and Book cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.updateBook(bookCopy);
    }
    
    public List<BookCopy> searchBooks(String branchId, SearchQuery query) {
        if (branchId == null || query == null) {
            throw new IllegalArgumentException("Branch ID and query cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        return branch.searchBook(query);
    }
    
    public void reserveBook(String branchId, String isbn, Learner learner) {
        if (branchId == null || isbn == null || learner == null) {
            throw new IllegalArgumentException("Branch ID, ISBN, and Learner cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.reserveBook(isbn, learner);
    }
    
    public void cancelReservation(String branchId, String isbn, Learner learner) {
        if (branchId == null || isbn == null || learner == null) {
            throw new IllegalArgumentException("Branch ID, ISBN, and Learner cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.cancelReservation(isbn, learner);
    }
    
    public void checkOut(String branchId, BookCopy bookCopy, Learner learner) {
        if (branchId == null || bookCopy == null || learner == null) {
            throw new IllegalArgumentException("Branch ID, Book, and Learner ID cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.checkOutBook(bookCopy, learner);
    }
    
    public void returnBook(String branchId, BookCopy bookCopy, Learner learner) {
        if (branchId == null || bookCopy == null || learner == null) {
            throw new IllegalArgumentException("Branch ID, Book, and Learner ID cannot be null");
        }
        LibraryBranch branch = libraryBranches.get(branchId);
        if (branch == null) {
            throw new IllegalArgumentException("Library branch does not exist");
        }
        branch.returnBook(bookCopy, learner);
    }
}
