package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class AgedBrie extends Updatable {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public Item update() {
        if (sellInIsExpiredAfterUpdate()) {
            return new Item(item.name, decreaseSellIn(), increaseQualityBy(2));
        } else {
            return new Item(item.name, decreaseSellIn(), increaseQualityBy(1));
        }
    }

}
