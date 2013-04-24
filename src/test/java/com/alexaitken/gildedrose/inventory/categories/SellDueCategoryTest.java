package com.alexaitken.gildedrose.inventory.categories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import com.alexaitken.gildedrose.inventory.InventoriedItem;
import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;
import com.alexaitken.gildedrose.inventory.categories.Category;

/**
 * Abstract test suite containing tests common to all {@link Category}
 * implementations which have to manage a sell due date
 */
public abstract class SellDueCategoryTest extends BaseCategoryTest {

	@Test
	public void shouldDecrementSellInForAllItems() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(3), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(4), Quality.rate(10));

		Category subject = buildSubject(firstItem, secondItem);

		subject.newDay();

		assertThat(firstItem.getSellIn(), is(equalTo(2)));
		assertThat(secondItem.getSellIn(), is(equalTo(3)));
	}

}
