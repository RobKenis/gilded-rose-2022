package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieTest {

    private Updatable item;

    @BeforeEach
    void setUp() {
        this.item = new AgedBrie(new Item("test", 10, 10));
    }

    @Test
    void qualityIncreasesByOne() {
        Item update = item.update();
        assertEquals(11, update.quality);
    }

    @Test
    void qualityIncreasesByOneButNeverOver50() {
        Updatable item = new AgedBrie(new Item("test", 10, 50));
        Item update = item.update();
        assertEquals(50, update.quality);
    }

}
