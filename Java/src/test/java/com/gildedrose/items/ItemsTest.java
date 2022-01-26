package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {

    @Test
    void agedBrie() {
        Updatable updatable = Items.from(new Item("Aged Brie", 0, 0));
        assertEquals(AgedBrie.class, updatable.getClass());
    }

    @Test
    void sulfuras() {
        Updatable updatable = Items.from(new Item("Sulfuras, Hand of Ragnaros", 0, 0));
        assertEquals(Sulfuras.class, updatable.getClass());
    }

    @Test
    void passes() {
        Updatable updatable = Items.from(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0));
        assertEquals(BackstagePass.class, updatable.getClass());
    }

    @Test
    void normal() {
        Updatable updatable = Items.from(new Item("yeet", 0, 0));
        assertEquals(NormalItem.class, updatable.getClass());
    }
}
