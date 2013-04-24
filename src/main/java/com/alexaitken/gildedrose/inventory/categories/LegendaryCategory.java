package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Quality progression category for legendary items
 */
public class LegendaryCategory extends BaseCategory {

	/**
	 * Creates a new {@link LegendaryCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public LegendaryCategory(InventoriedItem... items) {
		super(items);
	}

	/**
	 * @see BaseCategory#processItemQuality(InventoriedItem)
	 */
	@Override
	protected void processItemQuality(InventoriedItem item) {
		checkNotNull(item);
		// Nothing to be done here, item quality and sell in should be constant
		// for these items
	}
}
