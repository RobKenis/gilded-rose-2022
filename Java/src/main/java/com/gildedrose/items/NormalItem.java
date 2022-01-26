package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class NormalItem extends Updatable {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public Item update() {
        return new Item(item.name, item.sellIn - 1, decreaseQualityBy(1));
    }
}
