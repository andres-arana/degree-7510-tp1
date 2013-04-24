package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Quality progression category for default items
 */
public class DefaultCategory extends SellDueCategory {

	/**
	 * Creates a new {@link DefaultCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public DefaultCategory(InventoriedItem... items) {
		super(items);
	}

	/**
	 * @see BaseCategory#processItemQuality(InventoriedItem)
	 */
	@Override
	protected void processItemQuality(InventoriedItem item) {
		checkNotNull(item);

		super.processItemQuality(item);
		if (item.isOverdue()) {
			decreaseItemQuality(item, 2);
		} else {
			decreaseItemQuality(item, 1);
		}
	}
}
