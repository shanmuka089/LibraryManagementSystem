package com.management.library.service;

import com.management.library.entity.BookCopy;
import com.management.library.entity.SearchQuery;
import com.management.library.inventory.InventorySupport;

import java.util.List;

public interface SearchSupport
{
    List<BookCopy> search(SearchQuery searchQuery, InventorySupport inventorySupport);
}
