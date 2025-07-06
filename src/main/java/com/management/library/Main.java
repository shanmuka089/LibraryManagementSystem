package com.management.library;

import com.management.library.branch.CentralLibrary;
import com.management.library.branch.spec.LibraryBranch;
import com.management.library.entity.Book;
import com.management.library.entity.BookCopy;
import com.management.library.entity.Learner;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.LibraryInventoryImpl;
import com.management.library.observer.BookNotifier;
import com.management.library.observer.BookNotifierImpl;
import com.management.library.service.LearnerManagement;
import com.management.library.service.impl.*;
import com.management.library.system.LibrarySystem;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        // initializing the learner management system
        // creating the library system with the learner management
        LibrarySystem librarySystem = new LibrarySystem(new LearnerManagementImpl());

        // initializing the book notifier
        BookNotifier bookNotifier = new BookNotifierImpl();
        
        // creating library branches with different configurations
        LibraryBranch branch1 = CentralLibrary.builder()
                .setBranchId("branch1")
                .setAddress("123 Main St")
                .setInventorySupport(new LibraryInventoryImpl()) 
                .setBorrowingSupport(new BorrowingSupportImpl(bookNotifier)) 
                .setSearchSupport(new TitleSearchSupport()) 
                .setReservationSupport(new ReservationSupportImpl(bookNotifier)) 
                .build();
        
        librarySystem.addLibraryBranch("branch1", branch1);
        
        BookNotifier bookNotifier2 = new BookNotifierImpl();
        LibraryBranch branch2 = CentralLibrary.builder()
                .setBranchId("branch2")
                .setAddress("456 Elm St")
                .setInventorySupport(new LibraryInventoryImpl()) 
                .setBorrowingSupport(new BorrowingSupportImpl(bookNotifier2)) 
                .setSearchSupport(new AuthorSearchSupport()) 
                .setReservationSupport(new ReservationSupportImpl(bookNotifier2)) 
                .build();
        librarySystem.addLibraryBranch("branch2", branch2);
        
        // adding books to the library branches
        LibraryBranch libraryBranch = librarySystem.getLibraryBranch("branch1");
        libraryBranch.addBook(new BookCopy("book1", new Book("Effective Java", "Joshua Bloch", "978-0134686097", "2008")));
        libraryBranch.addBook(new BookCopy("book1", new Book("Effective Java", "Joshua Bloch", "978-0134686097", "2008")));
        libraryBranch.addBook(new BookCopy("book2", new Book("Effective Java", "Joshua Bloch", "978-0134686097", "2008")));
        libraryBranch.addBook(new BookCopy("book3", new Book("Effective Java", "Joshua Bloch", "978-0134686097", "2008")));
        libraryBranch.addBook(new BookCopy("book4", new Book("Effective Java", "Joshua Bloch", "978-0134686097", "2008")));
        libraryBranch.addBook(new BookCopy("book1", new Book("Design Patterns", "Erich Gamma et al.", "978-0201633610", "1994")));
        libraryBranch.addBook(new BookCopy("book2", new Book("The Pragmatic Programmer", "Andrew Hunt and David Thomas", "978-0135957059", "2019")));
        libraryBranch.addBook(new BookCopy("book5", new Book("Clean Architecture", "Robert C. Martin", "978-0134494166", "2017")));

        LibraryBranch libraryBranch2 = librarySystem.getLibraryBranch("branch2");
        libraryBranch2.addBook(new BookCopy("book4", new Book("Refactoring", "Martin Fowler", "978-0134757599", "2018")));
        libraryBranch2.addBook(new BookCopy("book1", new Book("The Clean Coder", "Robert C. Martin", "978-0136083238", "2011")));
        libraryBranch2.addBook(new BookCopy("book1", new Book("Introduction to Algorithms", "Thomas H. Cormen et al.", "978-0262033848", "2009")));
        libraryBranch2.addBook(new BookCopy("book2", new Book("Clean Code", "Robert C. Martin", "978-0132350884", "2008")));
        
        // adding learners to the library system
        Learner l1 = new Learner("learner1", "Shanu");
        Learner l2 = new Learner("learner2", "John");
        Learner l3 = new Learner("learner3", "Jane");
        
        LearnerManagement learnerManagement = librarySystem.getLearnerManagement();
        learnerManagement.addLearner(l1.getId(), l1);
        learnerManagement.addLearner(l2.getId(), l2);
        learnerManagement.addLearner(l3.getId(), l3);
        
        // searching for books in the library branches
        System.out.println("Search results for 'Effective Java':");
        BookCopy bookCopy = libraryBranch.searchBook(SearchQuery.builder().setTitle("Effective Java").build())
                .stream().findFirst().get();
        
        // simulate a delay to mimic real-world search operation
        Thread.sleep(5000);
        
        System.out.println("Found book: " + bookCopy.getBook().getTitle() + " by " + bookCopy.getBook().getAuthor());
        
        BookCopy bookCopy2 = libraryBranch.searchBook(SearchQuery.builder().setTitle("Design Patterns").build())
                .stream().findFirst().get();
        
        // simulate a delay to mimic real-world search operation
        Thread.sleep(5000);
        
        System.out.println("Found book: " + bookCopy2.getBook().getTitle() + " by " + bookCopy2.getBook().getAuthor());
        
        
        // checkout a book for a learner
        libraryBranch.checkOutBook(bookCopy, l1);
        libraryBranch.checkOutBook(bookCopy2, l1);
        
        // simulate a delay to mimic real-world checkout operation
        Thread.sleep(5000);
        
        // check borrowing history
        libraryBranch.getLearnerBorrowHistory("learner1")
                .forEach(borrowedBook -> System.out.println(borrowedBook));
        
        // simulate a delay to mimic real-world operation
        Thread.sleep(5000);
        
        // return a book
        libraryBranch.returnBook(bookCopy, l1);
        
        // check borrowing history after returning a book
        System.out.println("Borrowing history after returning a book:");
        libraryBranch.getLearnerBorrowHistory("learner1")
                .forEach(borrowedBook -> System.out.println(borrowedBook));
        
        
        // search for a book by author
        System.out.println("Search results for books by 'Martin Flower':");
        BookCopy bookCopy3 = libraryBranch2.searchBook(SearchQuery.builder().setAuthor("Martin Fowler").build())
                .stream().findFirst().get();   
        
        // simulate a delay to mimic real-world search operation
        Thread.sleep(5000);
        
        // checkout by learner2
        libraryBranch2.checkOutBook(bookCopy3, l2);
        
        // simulate a delay to mimic real-world checkout operation
        Thread.sleep(5000);
        
        // check borrowing history for learner2
        System.out.println("Borrowing history for learner2:");
        libraryBranch2.getLearnerBorrowHistory("learner2")
                .forEach(borrowedBook -> System.out.println(borrowedBook));

        // checkout by learner3
        libraryBranch2.checkOutBook(bookCopy3, l3);
        
        // simulate a delay to mimic real-world checkout operation
        Thread.sleep(5000);
        
        // reserve a book by learner3
        System.out.println("Reserving book for learner3:");
        
        // simulate a delay to mimic real-world reservation operation
        Thread.sleep(5000);
        
        libraryBranch2.reserveBook(bookCopy3.getBook().getIsbn(), l3);
        System.out.println("Reservation successful for book: " + bookCopy3.getBook().getTitle() + " by " + l3.getName());
        
        // simulate a delay to mimic real-world reservation operation
        Thread.sleep(5000);
        
        // return a book by learner2
        System.out.println("Returning book by learner2:");
        libraryBranch2.returnBook(bookCopy3, l2);
        
        // fetch borrowing history for learner2 after returning the book
        System.out.println("Borrowing history for learner2 after returning the book:");
        libraryBranch2.getLearnerBorrowHistory("learner2")
                .forEach(borrowedBook -> System.out.println(borrowedBook));
    }

}