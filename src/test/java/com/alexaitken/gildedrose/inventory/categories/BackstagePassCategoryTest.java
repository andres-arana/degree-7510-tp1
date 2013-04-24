package com.alexaitken.gildedrose.inventory.categories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import com.alexaitken.gildedrose.inventory.InventoriedItem;
import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;
import com.alexaitken.gildedrose.inventory.categories.BackstagePassCategory;
import com.alexaitken.gildedrose.inventory.categories.Category;

/**
 * Test suite for the {@link BackstagePassCategory} class
 */
public class BackstagePassCategoryTest extends
		SellDueCategoryTest {

	/**
	 * @see BaseCategoryTest#buildSubject(InventoriedItem...)
	 */
	@Override
	protected Category buildSubject(InventoriedItem... items) {
		return new BackstagePassCategory(items);
	}

	@Test
	public void shouldIncreaseQualityEachDayBefore10DaysToSellDue() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(12), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(15), Quality.rate(10));

		BackstagePassCategory subject = new BackstagePassCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(6)));
		assertThat(secondItem.getQuality(), is(equalTo(11)));
	}
	
	@Test
	public void shouldIncreaseQualityFasterEachDayBefore5DaysToSellDue() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(11), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(7), Quality.rate(10));

		BackstagePassCategory subject = new BackstagePassCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(7)));
		assertThat(secondItem.getQuality(), is(equalTo(12)));
	}
	
	@Test
	public void shouldIncreaseQualityEvenFasterEachDayBeforeSellDue() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(6), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(2), Quality.rate(10));

		BackstagePassCategory subject = new BackstagePassCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(8)));
		assertThat(secondItem.getQuality(), is(equalTo(13)));
	}
	
	@Test
	public void shouldDropQualityTo0AfterSellDue() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(1), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(-3), Quality.rate(10));

		BackstagePassCategory subject = new BackstagePassCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(0)));
		assertThat(secondItem.getQuality(), is(equalTo(0)));
	}

}
