package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassTest {

    @Test
    void increaseByOne() {
        Updatable item = new BackstagePass(new Item("test", 20, 5));
        Item update = item.update();
        assertEquals(6, update.quality);
    }

    @Test
    void increaseByTwo() {
        Updatable item = new BackstagePass(new Item("test", 9, 5));
        Item update = item.update();
        assertEquals(7, update.quality);
    }

    @Test
    void increaseByThree() {
        Updatable item = new BackstagePass(new Item("test", 2, 5));
        Item update = item.update();
        assertEquals(8, update.quality);
    }

    @Test
    void goToZero() {
        Updatable item = new BackstagePass(new Item("test", 0, 5));
        Item update = item.update();
        assertEquals(0, update.quality);
        assertEquals(-1, update.sellIn);
    }
}
