package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import com.alexaitken.gildedrose.inventory.InventoriedItem;

/**
 * Quality progression category for backstage pass items
 */
public class BackstagePassCategory extends SellDueCategory {

	/**
	 * Creates a new {@link BackstagePassCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public BackstagePassCategory(InventoriedItem... items) {
		super(items);
	}

	/**
	 * @see BaseCategory#processItemQuality(InventoriedItem)
	 */
	@Override
	protected void processItemQuality(InventoriedItem item) {
		checkNotNull(item);

		super.processItemQuality(item);
		if (item.getSellIn() > 10) {
			increaseItemQuality(item, 1);
		} else if (item.getSellIn() <= 10 && item.getSellIn() > 5) {
			increaseItemQuality(item, 2);
		} else if (item.getSellIn() <= 5 && item.getSellIn() > 0) {
			increaseItemQuality(item, 3);
		} else {
			item.setQuality(0);
		}
	}
}
