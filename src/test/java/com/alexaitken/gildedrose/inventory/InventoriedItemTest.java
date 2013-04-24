package com.alexaitken.gildedrose.inventory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.alexaitken.gildedrose.inventory.InventoriedItem.Quality;
import com.alexaitken.gildedrose.inventory.InventoriedItem.SellIn;

/**
 * Test suite for the {@link InventoriedItem} class
 */
public class InventoriedItemTest extends BaseJUnit4Test {
	/**
	 * Default subject name
	 */
	private static final String DEFAULT_NAME = "Name";

	/**
	 * Default subject sell in
	 */
	private static final int DEFAULT_SELL_IN = 5;

	/**
	 * Default subject quality
	 */
	private static final int DEFAULT_QUALITY = 3;

	/**
	 * Instance under test, rebuilt with default values before each test
	 */
	private InventoriedItem subject;

	@Before
	public void setUpSubject() {
		subject = new InventoriedItem(DEFAULT_NAME,
				SellIn.days(DEFAULT_SELL_IN), Quality.rate(DEFAULT_QUALITY));
	}

	@Test
	public void shouldBuildUsingSemanticSyntax() {
		assertThat(subject.getName(), is(equalTo(DEFAULT_NAME)));
		assertThat(subject.getSellIn(), is(equalTo(DEFAULT_SELL_IN)));
		assertThat(subject.getQuality(), is(equalTo(DEFAULT_QUALITY)));
	}

	@Test
	public void shouldDecrementSellIn() {
		subject.updateSellDueDate();

		assertThat(subject.getSellIn(), is(equalTo(DEFAULT_SELL_IN - 1)));
	}

	@Test
	public void shouldDecrementQuality() {
		subject.decreaseQuality(2, Quality.rate(DEFAULT_QUALITY - 10));

		assertThat(subject.getQuality(), is(equalTo(DEFAULT_QUALITY - 2)));
	}

	@Test
	public void shouldNeverDecrementQualityBelowMinimum() {
		subject.decreaseQuality(DEFAULT_QUALITY + 1, Quality.rate(0));

		assertThat(subject.getQuality(), is(equalTo(0)));
	}

	@Test
	public void shouldIncreaseQuality() {
		subject.increaseQuality(10, Quality.rate(DEFAULT_QUALITY + 20));

		assertThat(subject.getQuality(), is(equalTo(DEFAULT_QUALITY + 10)));
	}

	@Test
	public void shouldNeverIncreaseQualityAboveMaximum() {
		subject.increaseQuality(10, Quality.rate(DEFAULT_QUALITY + 5));

		assertThat(subject.getQuality(), is(equalTo(DEFAULT_QUALITY + 5)));
	}

	@Test
	public void shouldBeOverdueWhenOverdue() {
		subject.setSellIn(0);

		assertThat(subject.isOverdue(), is(equalTo(true)));
	}

	@Test
	public void shouldNotBeOverdueWhenNotOverdue() {
		subject.setSellIn(1);

		assertThat(subject.isOverdue(), is(equalTo(false)));
	}

}
