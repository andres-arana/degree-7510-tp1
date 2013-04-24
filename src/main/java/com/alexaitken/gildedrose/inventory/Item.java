package com.alexaitken.gildedrose.inventory;

/**
 * Represents a item which can be sold at the hotel
 */
public class Item {

	/**
	 * The name of the item
	 */
	private String name;

	/**
	 * The amount of days until the maximum sell date. After this date is
	 * reached, most items will degrade at a much faster peace.
	 */
	private int sellIn;

	/**
	 * The quality of the item, related to the price at which it will be sold
	 */
	private int quality;

	/**
	 * Creates a new {@link Item} instance
	 * 
	 * @param name
	 *            The name of the item
	 * @param sellIn
	 *            The amount of days until the maximum sell date. After this
	 *            date is reached, most items will degrade at a much faster
	 *            peace.
	 * @param quality
	 *            The quality of the item, related to the price at which it will
	 *            be sold
	 */
	public Item(String name, int sellIn, int quality) {
		super();
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	/**
	 * Obtains the name of the item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a new name of the item
	 * 
	 * @param name
	 *            the new name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtains the amount of days until the maximum sell date. After this date
	 * is reached, most items will degrade at a much faster peace.
	 */
	public int getSellIn() {
		return sellIn;
	}

	/**
	 * Sets a new amount of days until the maximum sell date. After this date is
	 * reached, most items will degrade at a much faster peace.
	 * 
	 * @param sellIn
	 *            The new amount of days to set
	 */
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	/**
	 * Obtains the quality of the item, related to the price at which it will be
	 * sold
	 */
	public int getQuality() {
		return quality;
	}

	/**
	 * Sets a new quality of the item, related to the price at which it will be
	 * sold
	 * 
	 * @param quality
	 *            The new quality to set
	 */
	public void setQuality(int quality) {
		this.quality = quality;
	}
}
