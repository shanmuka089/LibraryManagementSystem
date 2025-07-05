package com.management.library.service;

import com.management.library.entity.BookCopy;
import com.management.library.entity.BorrowedBook;
import com.management.library.entity.Learner;
import com.management.library.inventory.InventorySupport;

import java.util.List;

public interface BorrowingSupport
{
    void checkOut(BookCopy copy, Learner learner, InventorySupport inventorySupport);
    void returnCopy(BookCopy copy, Learner learner, InventorySupport inventorySupport);
    List<BorrowedBook> getLearnerBorrowHistory(String learnerId);
}
