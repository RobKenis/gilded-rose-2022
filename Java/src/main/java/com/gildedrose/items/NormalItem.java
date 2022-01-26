package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class NormalItem extends Updatable {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public Item update() {
        if (sellInIsExpiredAfterUpdate()) {
            return new Item(item.name, decreaseSellIn(), decreaseQualityBy(2));
        } else {
            return new Item(item.name, decreaseSellIn(), decreaseQualityBy(1));
        }
    }
}
