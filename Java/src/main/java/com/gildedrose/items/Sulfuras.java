package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class Sulfuras implements Updatable {

    private final Item item;

    public Sulfuras(Item item) {
        this.item = item;
    }

    @Override
    public Item update() {
        return null;
    }
}
