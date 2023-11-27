package com.gildedrose.handler;

import com.gildedrose.ItemWrapper;

public class BackstagePassHandler implements ItemHandler {

    public static final int SELLIN_TRESHOLD_1 = 10;
    public static final int SELLIN_TRESHOLD_2 = 5;

    @Override
    public void handle(ItemWrapper item) {
        item.decreaseSellIn();

        if (item.getSellIn() < 0) {
            item.resetQuality();
        }
        else {
            item.increaseQuality();

            if (item.getSellIn() < SELLIN_TRESHOLD_1) item.increaseQuality();
            if (item.getSellIn() < SELLIN_TRESHOLD_2) item.increaseQuality();
        }
    }
}
