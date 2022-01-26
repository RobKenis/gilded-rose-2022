package com.gildedrose;

public abstract class Updatable {

    protected final Item item;

    protected Updatable(Item item) {
        this.item = item;
    }

    public abstract Item update();

    protected int decreaseQualityBy(int amount) {
        int newQuality = item.quality - amount;
        return Math.max(newQuality, 0);
    }

}
