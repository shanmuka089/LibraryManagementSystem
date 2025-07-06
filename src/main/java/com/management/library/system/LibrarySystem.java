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
    
    public LearnerManagement getLearnerManagement() {
        return learnerManagement;
    }
}
