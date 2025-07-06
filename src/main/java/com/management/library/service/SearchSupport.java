package com.management.library.service;

import com.management.library.entity.BookCopy;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;

import java.util.Set;

public interface SearchSupport
{
    Set<BookCopy> search(SearchQuery searchQuery, InventorySupport inventorySupport);
}
