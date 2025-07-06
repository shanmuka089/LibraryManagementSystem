package com.management.library.service.impl;

import com.management.library.entity.BookCopy;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;
import com.management.library.service.SearchSupport;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorSearchSupport implements SearchSupport
{

    @Override
    public Set<BookCopy> search(SearchQuery searchQuery, InventorySupport inventorySupport)
    {
        System.out.println("Searching for books by author: " + searchQuery.getAuthor());
        return inventorySupport.getAllBookCopies()
                .stream()
                .filter(bookCopy -> searchQuery.getAuthor().equals(bookCopy.getBook().getAuthor()))
                .collect(Collectors.toSet());
    }

}
