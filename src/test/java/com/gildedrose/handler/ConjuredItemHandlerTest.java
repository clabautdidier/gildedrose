package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemName;
import com.gildedrose.ItemWrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemHandlerTest {
    ConjuredItemHandler conjuredItemHandler = new ConjuredItemHandler();

    @Test
    void handle_sellInAboveZero_qualityDecreasesWith2() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.CONJURED, 1, 5));

        conjuredItemHandler.handle(itemWrapper);

        assertEquals(0, itemWrapper.getSellIn());
        assertEquals(3, itemWrapper.getQuality());
    }

    @Test
    void handle_sellInAboveZero_qualityAtZero_qualityRemainsZero() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.CONJURED, 1, 0));

        conjuredItemHandler.handle(itemWrapper);

        assertEquals(0, itemWrapper.getSellIn());
        assertEquals(0, itemWrapper.getQuality());
    }

    @Test
    void handle_sellInBelowZero_qualityDecreasesWith4() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.CONJURED, 0, 5));

        conjuredItemHandler.handle(itemWrapper);

        assertEquals(-1, itemWrapper.getSellIn());
        assertEquals(1, itemWrapper.getQuality());
    }
}
