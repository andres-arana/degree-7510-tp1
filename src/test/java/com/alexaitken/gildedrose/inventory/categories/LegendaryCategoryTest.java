package com.alexaitken.gildedrose.inventory.categories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import com.alexaitken.gildedrose.inventory.InventoriedItem;
import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;
import com.alexaitken.gildedrose.inventory.categories.LegendaryCategory;
import com.alexaitken.gildedrose.inventory.categories.Category;

/**
 * Test suite for the {@link LegendaryCategory} class
 */
public class LegendaryCategoryTest extends
		BaseCategoryTest {

	/**
	 * @see BaseCategoryTest#buildSubject(InventoriedItem...)
	 */
	@Override
	protected Category buildSubject(InventoriedItem... items) {
		return new LegendaryCategory(items);
	}

	@Test
	public void shouldMantainConstantSellIn() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(3), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(4), Quality.rate(10));

		LegendaryCategory subject = new LegendaryCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getSellIn(), is(equalTo(3)));
		assertThat(secondItem.getSellIn(), is(equalTo(4)));
	}

	@Test
	public void shouldMantainConstantQuality() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(3), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(4), Quality.rate(10));

		LegendaryCategory subject = new LegendaryCategory(
				firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getQuality(), is(equalTo(5)));
		assertThat(secondItem.getQuality(), is(equalTo(10)));
	}

}
