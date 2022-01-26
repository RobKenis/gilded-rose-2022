package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class BackstagePass extends Updatable {

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    public Item update() {
        if (sellInIsExpiredAfterUpdate()) {
            return new Item(item.name, decreaseSellIn(), 0);
        } else {
            if (item.sellIn <= 5){
                return new Item(item.name, decreaseSellIn(), increaseQualityBy(3));
            }
            if (item.sellIn <= 10){
                return new Item(item.name, decreaseSellIn(), increaseQualityBy(2));
            }
            return new Item(item.name, decreaseSellIn(), increaseQualityBy(1));
        }
    }
}
