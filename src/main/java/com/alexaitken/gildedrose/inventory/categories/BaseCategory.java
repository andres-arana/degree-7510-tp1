package com.alexaitken.gildedrose.inventory.categories;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import com.alexaitken.gildedrose.inventory.InventoriedItem;
import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;

/**
 * Base {@link Category} implementation
 */
public abstract class BaseCategory implements Category {
	/**
	 * The items belonging to this category
	 */
	private final List<InventoriedItem> items;

	/**
	 * Creates a new {@link BaseCategory} instance
	 * 
	 * @param items
	 *            The items belonging to this category
	 */
	public BaseCategory(InventoriedItem... items) {
		this.items = new ArrayList<>();
		for (InventoriedItem item : items) {
			checkNotNull(item, "None of the items can be null");
			this.items.add(item);
		}
	}

	/**
	 * @see Category#newDay()
	 */
	@Override
	public void newDay() {
		for (InventoriedItem item : items) {
			processItemQuality(item);
		}
	}

	/**
	 * @see Category#getItems()
	 */
	@Override
	public List<InventoriedItem> getItems() {
		return items;
	}

	/**
	 * Decreases the quality of an item, checking the configured bounds for the
	 * category
	 * 
	 * @param item
	 *            the item to decrease quality from
	 * @param amount
	 *            the amount to decrease
	 */
	protected void decreaseItemQuality(final InventoriedItem item,
			final int amount) {
		checkNotNull(item);
		item.decreaseQuality(amount, getMinimumQualityAmount());
	}

	/**
	 * Obtains the minimum quality for items in this category. Defaults to 0.
	 */
	protected Quality getMinimumQualityAmount() {
		return Quality.rate(0);
	}

	/**
	 * Increases the quality of an item, checking the configured bounds for the
	 * category
	 * 
	 * @param item
	 *            the item to increase quality from
	 * @param amount
	 *            the amount to increase
	 */
	protected void increaseItemQuality(final InventoriedItem item,
			final int amount) {
		checkNotNull(item);
		item.increaseQuality(amount, getMaximumQualityAmount());
	}

	/**
	 * Obtains the maximum quality for items in this category. Defaults to 50.
	 */
	private Quality getMaximumQualityAmount() {
		return Quality.rate(50);
	}

	/**
	 * Processes the quality of a given item
	 * 
	 * @param item
	 *            the item to process
	 */
	protected abstract void processItemQuality(InventoriedItem item);
}
