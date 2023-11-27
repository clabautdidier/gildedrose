package com.gildedrose;

public class ItemWrapper {
    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void increaseQuality() {
        if (item.quality < 50) item.quality++;
    }

    public void decreaseQuality() {
        if (item.quality > 0) item.quality--;
    }

    public void decreaseSellIn() {
        item.sellIn--;
    }

    public void resetQuality() {
        item.quality = 0;
    }

    public String getName() {
        return item.name;
    }
}
