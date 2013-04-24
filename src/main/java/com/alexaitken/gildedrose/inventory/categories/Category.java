package com.alexaitken.gildedrose.inventory.categories;

import java.util.List;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Interface representing an object in charge of managing the quality
 * progression of a set of items
 */
public interface Category {
	/**
	 * Updates the quality and sell-in attributes of the set of managed items
	 */
	void newDay();

	/**
	 * Obtains the items belonging to this category
	 */
	List<InventoriedItem> getItems();

}
