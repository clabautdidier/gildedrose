package com.gildedrose;

import com.gildedrose.handler.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemHandler itemHandler = ItemHandler.forItem(item.name);
            itemHandler.handle(new ItemWrapper(item));
        }
    }
}
