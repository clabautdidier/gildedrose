package com.gildedrose;

import com.gildedrose.handler.AgedBrieHandler;
import com.gildedrose.handler.BackstagePassHandler;
import com.gildedrose.handler.ItemHandler;
import com.gildedrose.handler.ConstantQualityItemHandler;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                ItemHandler itemHandler = new AgedBrieHandler();
                itemHandler.handle(new ItemWrapper(item));
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                ItemHandler itemHandler = new BackstagePassHandler();
                itemHandler.handle(new ItemWrapper(item));
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                ItemHandler itemHandler = new ConstantQualityItemHandler();
                itemHandler.handle(new ItemWrapper(item));
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }
}
