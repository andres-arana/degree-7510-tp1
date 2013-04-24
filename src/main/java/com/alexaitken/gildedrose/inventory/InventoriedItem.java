package com.alexaitken.gildedrose.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents an item which is in the inventory.
 */
public class InventoriedItem extends Item {
	/**
	 * Used for semantically building an {@link InventoriedItem}.
	 */
	public static class SellIn {
		/**
		 * The sell in days
		 */
		private int sellIn;

		/**
		 * Creates a new {@link SellIn} instance
		 * 
		 * @param days
		 *            The sell in days
		 */
		private SellIn(final int days) {
			this.sellIn = days;
		}

		/**
		 * Obtains the sell in days
		 */
		public int getDays() {
			return sellIn;
		}

		/**
		 * Creates a {@link SellIn} instance which represents a certain amount
		 * of sell in days
		 * 
		 * @param days
		 *            The amount of sell in days
		 */
		public static SellIn days(final int days) {
			return new SellIn(days);
		}
	}

	/**
	 * Used for semantically building an {@link InventoriedItem}.
	 */
	public static class Quality {
		/**
		 * The quality amount
		 */
		private int quality;

		/**
		 * Creates a new {@link Quality} instance
		 * 
		 * @param quality
		 *            The quality amount
		 */
		private Quality(final int quality) {
			this.quality = quality;
		}

		/**
		 * Obtains the quality amount
		 */
		public int getRate() {
			return quality;
		}

		/**
		 * Creates a {@link Quality} instance which represents a certain quality
		 * amount
		 * 
		 * @param quality
		 *            The quality amount
		 */
		public static Quality rate(final int quality) {
			return new Quality(quality);
		}
	}

	/**
	 * Creates a new {@link InventoriedItem}, using a semantic syntax.
	 * 
	 * For example:
	 * 
	 * <pre>
	 * {@code
	 * new InventoriedItem("Name", SellIn.days(3), Quality.rate(2));
	 * }
	 * </pre>
	 * 
	 * @param name
	 *            The name of the inventoried item
	 * @param sellIn
	 *            The amount of days until sell in. You need to build a
	 *            {@link SellIn} instance using the {@link SellIn#days(int)}
	 *            method to pass the sell in days here.
	 * @param quality
	 *            The quality amount. You need to build a {@link Quality}
	 *            instance using {@link Quality#rate(int)} method to pass the
	 *            quality here.
	 */
	public InventoriedItem(final String name, final SellIn sellIn,
			final Quality quality) {
		super(null, 0, 0);

		checkNotNull(name);
		checkNotNull(sellIn);
		checkNotNull(quality);

		setName(name);
		setSellIn(sellIn.getDays());
		setQuality(quality.getRate());
	}

	/**
	 * Signals that a new day has arrived, decreasing the sell in amount
	 * accordingly
	 */
	public void updateSellDueDate() {
		setSellIn(getSellIn() - 1);
	}

	/**
	 * Decreases the item quality in a given amount, without going below a given
	 * threshold
	 * 
	 * @param amount
	 *            the amount to decrease
	 * @param minimum
	 *            the minimum quality to decrease to
	 */
	public void decreaseQuality(int amount, Quality minimum) {
		checkNotNull(minimum);

		int newQuality = getQuality() - amount;
		if (newQuality < minimum.getRate()) {
			newQuality = minimum.getRate();
		}
		setQuality(newQuality);
	}

	/**
	 * Increases the item quality in a given amount, without going above a given
	 * threshold
	 * 
	 * @param amount
	 *            the amount to increase
	 * @param maximum
	 *            the maximum quality to increase to
	 */
	public void increaseQuality(int amount, Quality maximum) {
		checkNotNull(maximum);

		int newQuality = getQuality() + amount;
		if (newQuality > maximum.getRate()) {
			newQuality = maximum.getRate();
		}
		setQuality(newQuality);

	}

	/**
	 * Checks if the item should already have sold, returning true if it has and
	 * false otherwise
	 */
	public boolean isOverdue() {
		return getSellIn() <= 0;
	}
}
