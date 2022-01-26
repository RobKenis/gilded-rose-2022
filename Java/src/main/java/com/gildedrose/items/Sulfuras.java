package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class Sulfuras extends Updatable {

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public Item update() {
        return new Item(item.name, decreaseSellIn(), item.quality);
    }
}
