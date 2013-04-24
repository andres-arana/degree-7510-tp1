package com.alexaitken.gildedrose.inventory.categories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import com.alexaitken.gildedrose.inventory.InventoriedItem;
import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;
import com.alexaitken.gildedrose.inventory.categories.AgedCategory;
import com.alexaitken.gildedrose.inventory.categories.Category;

/**
 * Test suite for the {@link AgedCategory} class
 */
public class AgedCategoryTest extends
		SellDueCategoryTest {

	/**
	 * @see BaseCategoryTest#buildSubject(InventoriedItem...)
	 */
	@Override
	protected Category buildSubject(InventoriedItem... items) {
		return new AgedCategory(items);
	}

	@Test
	public void shouldIncreaseQualityEachDay() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(3), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(4), Quality.rate(10));

		AgedCategory subject = new AgedCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(6)));
		assertThat(secondItem.getQuality(), is(equalTo(11)));
	}

	@Test
	public void shouldNeverIncreaseAboveMaximum() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(3), Quality.rate(50));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(4), Quality.rate(50));

		AgedCategory subject = new AgedCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(50)));
		assertThat(secondItem.getQuality(), is(equalTo(50)));
	}

}
