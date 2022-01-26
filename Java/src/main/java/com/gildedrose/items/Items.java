package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

public class Items {

    public static Updatable from(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrie(item);
        }
        if (item.name.startsWith("Sulfuras")) {
            return new Sulfuras(item);
        }
        if (item.name.startsWith("Backstage passes")) {
            return new BackstagePass(item);
        }
        if (item.name.startsWith("Conjured")) {
            return new Conjured(item);
        }
        return new NormalItem(item);
    }

}
