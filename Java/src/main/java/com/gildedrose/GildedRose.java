package com.gildedrose;

import com.gildedrose.items.Items;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i] = Items.from(items[i]).update();
        }
    }
}
