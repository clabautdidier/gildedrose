package com.gildedrose.handler;

import com.gildedrose.ItemWrapper;

public class BackstagePassHandler implements ItemHandler {
    @Override
    public void handle(ItemWrapper item) {
        item.decreaseSellIn();

        if (item.getSellIn() < 0) {
            item.resetQuality();
        }
        else {
            item.increaseQuality();

            if (item.getSellIn() < 10) item.increaseQuality();
            if (item.getSellIn() < 5) item.increaseQuality();
        }
    }
}
