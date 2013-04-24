package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Quality progression category for conjured items
 */
public class ConjuredCategory extends SellDueCategory {

	/**
	 * Creates a new {@link ConjuredCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public ConjuredCategory(InventoriedItem... items) {
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
			decreaseItemQuality(item, 4);
		} else {
			decreaseItemQuality(item, 2);
		}
	}
}
