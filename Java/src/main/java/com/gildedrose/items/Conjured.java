package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class Conjured extends Updatable {

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public Item update() {
        return new Item(item.name, decreaseSellIn(), decreaseQualityBy(2));
    }
}
