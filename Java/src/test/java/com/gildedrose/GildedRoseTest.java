package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;

    @Test
    @Disabled("Let's write a proper test")
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @BeforeEach
    void setUp() {
        items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};
    }

    @Test
    void superGenericTestForAllItems() {
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", 9, 19);
        verifyItem(items[1], "Aged Brie", 1, 1);
        verifyItem(items[2], "Elixir of the Mongoose", 4, 6);
        verifyItem(items[3], "Sulfuras, Hand of Ragnaros", 0, 80);
        verifyItem(items[4], "Sulfuras, Hand of Ragnaros", -1, 80);
        verifyItem(items[5], "Backstage passes to a TAFKAL80ETC concert", 14, 21);
        verifyItem(items[6], "Backstage passes to a TAFKAL80ETC concert", 9, 50);
        verifyItem(items[7], "Backstage passes to a TAFKAL80ETC concert", 4, 50);
    }

    @Test
    void conjuredManaCake() {
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[8], "Conjured Mana Cake", 2, 4);
    }

    @Test
    void onceTheSellByDateHasPassedTheItemDegradesTwiceAsFast() {
        Item[] items = {new Item("+5 Dexterity Vest", 2, 20)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", 1, 19);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", 0, 18);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", -1, 16);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", -2, 14);
    }

    @Test
    void theQualityOfAnItemIsNeverNegative() {
        Item[] items = {new Item("+5 Dexterity Vest", 2, 2)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", 1, 1);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", 0, 0);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", -1, 0);
        app.updateQuality();
        verifyItem(items[0], "+5 Dexterity Vest", -2, 0);
    }

    @Test
    void agedBrieActuallyIncreasesInValueTheOlderItGets() {
        Item[] items = {new Item("Aged Brie", 2, 2)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", 1, 3);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", 0, 4);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", -1, 6);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", -2, 8);
    }

    @Test
    void theQualityOfAnItemIsNeverMoreThan50() {
        Item[] items = {new Item("Aged Brie", 2, 47)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", 1, 48);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", 0, 49);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", -1, 50);
        app.updateQuality();
        verifyItem(items[0], "Aged Brie", -2, 50);
    }

    @Test
    void sulfurasNeverHasToBeSoldOrDecreasedInValue() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        verifyItem(items[0], "Sulfuras, Hand of Ragnaros", 2, 80);
    }

    @Test
    void backStagePassesIncreaseInValueAsItsSellByDateApproaches() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21)};
        final GildedRose app = new GildedRose(items);
        app.updateQuality();
        verifyItem(items[0], "Backstage passes to a TAFKAL80ETC concert", 13, 22);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        verifyItem(items[0], "Backstage passes to a TAFKAL80ETC concert", 9, 27);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        verifyItem(items[0], "Backstage passes to a TAFKAL80ETC concert", 1, 47);
        app.updateQuality();
        verifyItem(items[0], "Backstage passes to a TAFKAL80ETC concert", 0, 50);
        app.updateQuality();
        verifyItem(items[0], "Backstage passes to a TAFKAL80ETC concert", -1, 0);
    }

    private void verifyItem(Item actual, String expectedName, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedName, actual.name);
        assertEquals(expectedSellIn, actual.sellIn);
        assertEquals(expectedQuality, actual.quality);
    }

}
