package com.gildedrose.handler;

import com.gildedrose.ItemWrapper;

public class AgedBrieHandler implements ItemHandler {
    @Override
    public void handle(ItemWrapper item) {
        item.increaseQuality();
        item.decreaseSellIn();

        if (item.getSellIn() < 0) item.increaseQuality();
    }
}
