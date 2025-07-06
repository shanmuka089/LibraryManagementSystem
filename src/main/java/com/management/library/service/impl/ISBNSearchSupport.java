package com.management.library.service.impl;

import com.management.library.entity.BookCopy;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;
import com.management.library.service.SearchSupport;

import java.util.Set;

public class ISBNSearchSupport implements SearchSupport
{

    @Override
    public Set<BookCopy> search(SearchQuery searchQuery, InventorySupport inventorySupport)
    {
        System.out.println("Searching for books with ISBN: " + searchQuery.getIsbn());
        return inventorySupport.getBookCopies(searchQuery.getIsbn());
    }

}
