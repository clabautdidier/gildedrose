package com.gildedrose.handler;

import com.gildedrose.ItemWrapper;

public class ConjuredItemHandler implements ItemHandler {

    public static final int QUALITY_LOSS = 2;

    @Override
    public void handle(ItemWrapper item) {
        item.decreaseQuality(QUALITY_LOSS);
        item.decreaseSellIn();

        if (item.getSellIn() < 0) item.decreaseQuality(QUALITY_LOSS);
    }
}
