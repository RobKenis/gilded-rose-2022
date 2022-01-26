package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasTest {

    @Test
    void sellInDecreasesButQualityNeverChanges() {
        Updatable item = new Sulfuras(new Item("test", 10, 80));
        Item update = item.update();
        assertEquals(9, update.sellIn);
        assertEquals(80, update.quality);
    }

}
