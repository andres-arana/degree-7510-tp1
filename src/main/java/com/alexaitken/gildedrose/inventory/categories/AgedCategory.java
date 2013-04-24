package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Quality progression category for aged items
 */
public class AgedCategory extends SellDueCategory {

	/**
	 * Creates a new {@link AgedCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public AgedCategory(InventoriedItem... items) {
		super(items);
	}

	/**
	 * @see BaseCategory#processItemQuality(InventoriedItem)
	 */
	@Override
	protected void processItemQuality(InventoriedItem item) {
		checkNotNull(item);

		super.processItemQuality(item);
		increaseItemQuality(item, 1);
	}
}
