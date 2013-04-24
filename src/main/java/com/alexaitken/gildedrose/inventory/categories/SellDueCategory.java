package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Base quality progression category for categories which have a sell due date
 */
public abstract class SellDueCategory extends BaseCategory {

	/**
	 * Creates a new {@link SellDueCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public SellDueCategory(InventoriedItem... items) {
		super(items);
	}

	/**
	 * @see BaseCategory#processItemQuality(InventoriedItem)
	 */
	@Override
	protected void processItemQuality(InventoriedItem item) {
		checkNotNull(item);
		item.updateSellDueDate();
	}
}
