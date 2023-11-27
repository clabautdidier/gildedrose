package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemWrapper;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemName.AGED_BRIE;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AgedBrieHandlerTest {
    AgedBrieHandler agedBrieHandler = new AgedBrieHandler();

    @Test
    void handle_qualityAt49_increasesTo50() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(AGED_BRIE, 12, 49));

        agedBrieHandler.handle(itemWrapper);

        assertEquals(50, itemWrapper.getQuality());
        assertEquals(11, itemWrapper.getSellIn());
    }

    @Test
    void handle_passedSellDate_qualityIncreasesDouble() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(AGED_BRIE, 0, 40));

        agedBrieHandler.handle(itemWrapper);

        assertEquals(-1, itemWrapper.getSellIn());
        assertEquals(42, itemWrapper.getQuality());
    }
}
