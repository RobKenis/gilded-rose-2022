package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalItemTest {

    private Updatable item;

    @BeforeEach
    void setUp() {
        this.item = new NormalItem(new Item("test", 10, 10));
    }

    @Test
    void sellByDecreases() {
        Item update = item.update();
        assertEquals(9, update.sellIn);
    }

    @Test
    void qualityDecreasesByOne() {
        Item update = item.update();
        assertEquals(9, update.quality);
    }

    @Test
    void qualityDecreasesByOneButNeverNegative() {
        Updatable item = new NormalItem(new Item("test", 10, 0));
        Item update = item.update();
        assertEquals(0, update.quality);
    }
}
