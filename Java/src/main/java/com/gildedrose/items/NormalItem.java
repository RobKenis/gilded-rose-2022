package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class NormalItem implements Updatable {

    private final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public Item update() {
        return null;
    }
}
