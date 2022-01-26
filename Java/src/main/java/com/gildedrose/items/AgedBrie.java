package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class AgedBrie implements Updatable {

    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public Item update() {
        return null;
    }

}
