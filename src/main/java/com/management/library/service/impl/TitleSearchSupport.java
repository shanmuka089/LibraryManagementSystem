package com.management.library.service.impl;

import com.management.library.entity.BookCopy;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;
import com.management.library.service.SearchSupport;

import java.util.Set;
import java.util.stream.Collectors;

public class TitleSearchSupport implements SearchSupport
{

    @Override
    public Set<BookCopy> search(SearchQuery searchQuery, InventorySupport inventorySupport)
    {
        System.out.println("Searching for books with title: " + searchQuery.getTitle());
        return inventorySupport.getAllBookCopies()
                .stream()
                .filter(bookCopy -> searchQuery.getTitle().equals(bookCopy.getBook().getTitle()))
                .collect(Collectors.toSet());
    }

}
