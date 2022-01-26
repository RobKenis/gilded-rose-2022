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
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @BeforeEach
    void setUp() {
        items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };
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

    private void verifyItem(Item actual, String expectedName, int expectedSellIn, int expectedQuality){
        assertEquals(expectedName, actual.name);
        assertEquals(expectedSellIn, actual.sellIn);
        assertEquals(expectedQuality, actual.quality);
    }

}
