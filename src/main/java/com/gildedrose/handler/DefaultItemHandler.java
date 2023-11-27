package com.gildedrose.handler;

import com.gildedrose.ItemWrapper;

public class DefaultItemHandler implements ItemHandler {
    @Override
    public void handle(ItemWrapper item) {
        item.decreaseQuality();
        item.decreaseSellIn();

        if (item.getSellIn() < 0) item.decreaseQuality();
    }
}
