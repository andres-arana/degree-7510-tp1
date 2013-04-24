package com.alexaitken.gildedrose.inventory;

import java.util.ArrayList;
import java.util.List;

import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;
import com.alexaitken.gildedrose.inventory.categories.AgedCategory;
import com.alexaitken.gildedrose.inventory.categories.BackstagePassCategory;
import com.alexaitken.gildedrose.inventory.categories.ConjuredCategory;
import com.alexaitken.gildedrose.inventory.categories.DefaultCategory;
import com.alexaitken.gildedrose.inventory.categories.LegendaryCategory;
import com.alexaitken.gildedrose.inventory.categories.Category;

/**
 * Manages the hotel inventory
 */
public class Inventory {
	/**
	 * The list of item categories containing the items in the hotel store
	 */
	private final List<Category> itemCategories = new ArrayList<>();

	/**
	 * Creates a new {@link Inventory} instance
	 */
	public Inventory() {
		itemCategories.add(
				new DefaultCategory(
						new InventoriedItem("+5 Dexterity Vest", SellIn.days(10), Quality.rate(20)),
						new InventoriedItem("Elixir of the Mongoose", SellIn.days(5), Quality.rate(7))));
		
		itemCategories.add(
				new AgedCategory(
						new InventoriedItem("Aged Brie", SellIn.days(2), Quality.rate(0))));
		
		itemCategories.add(
				new LegendaryCategory(
						new InventoriedItem("Sulfuras, Hand of Ragnaros", SellIn.days(0), Quality.rate(80))));
		
		itemCategories.add(
				new BackstagePassCategory(
						new InventoriedItem("Backstage passes to a TAFKAL80ETC concert", SellIn.days(15), Quality.rate(20))));
		
		itemCategories.add(
				new ConjuredCategory(
						new InventoriedItem("Conjured Mana Cake", SellIn.days(3), Quality.rate(6))));

	}

	/**
	 * Updates the inventory on a new day
	 */
	public void newDay() {
		for (Category category : itemCategories) {
			category.newDay();
		}
	}
}
