package com.gildedrose;

public abstract class Updatable {

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    protected final Item item;

    protected Updatable(Item item) {
        this.item = item;
    }

    public abstract Item update();

    protected int decreaseQualityBy(int amount) {
        int newQuality = item.quality - amount;
        return Math.max(newQuality, MINIMUM_QUALITY);
    }

    protected int increaseQualityBy(int amount) {
        int newQuality = item.quality + amount;
        return Math.min(newQuality, MAXIMUM_QUALITY);
    }

    protected boolean sellInIsExpiredAfterUpdate() {
        return item.sellIn <= 0;
    }

    protected int decreaseSellIn() {
        return item.sellIn - 1;
    }

}
