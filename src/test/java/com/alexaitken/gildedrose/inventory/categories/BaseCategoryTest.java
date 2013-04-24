package com.alexaitken.gildedrose.inventory.categories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import org.junit.Test;

import com.alexaitken.gildedrose.inventory.BaseJUnit4Test;
import com.alexaitken.gildedrose.inventory.InventoriedItem;
import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;
import com.alexaitken.gildedrose.inventory.categories.Category;

/**
 * Abstract test suite containing tests common to all
 * {@link Category} implementations
 */
public abstract class BaseCategoryTest extends BaseJUnit4Test {

	/**
	 * Obtains the concrete {@link Category} implementation to
	 * test
	 * 
	 * @param items
	 *            the items in the category
	 */
	protected abstract Category buildSubject(
			InventoriedItem... items);

	@Test
	public void shouldObtainTheItemList() {
		InventoriedItem firstItem = new InventoriedItem("First item",
				SellIn.days(3), Quality.rate(5));

		InventoriedItem secondItem = new InventoriedItem("Second item",
				SellIn.days(4), Quality.rate(10));

		Category subject = buildSubject(firstItem, secondItem);

		List<InventoriedItem> items = subject.getItems();

		assertThat(items.size(), is(equalTo(2)));
		assertThat(items.get(0), is(firstItem));
		assertThat(items.get(1), is(secondItem));
	}

}
