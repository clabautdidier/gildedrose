package com.gildedrose;

import com.gildedrose.handler.*;

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
                ItemHandler itemHandler = new DefaultItemHandler();
                itemHandler.handle(new ItemWrapper(item));
            }
        }
    }
}
