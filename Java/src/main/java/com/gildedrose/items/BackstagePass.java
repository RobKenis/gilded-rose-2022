package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class BackstagePass implements Updatable {

    private final Item item;

    public BackstagePass(Item item) {
        this.item = item;
    }

    @Override
    public Item update() {
        return null;
    }
}
