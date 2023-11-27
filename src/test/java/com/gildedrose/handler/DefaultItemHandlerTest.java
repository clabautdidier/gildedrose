package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemWrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultItemHandlerTest {
    DefaultItemHandler defaultItemHandler = new DefaultItemHandler();

    @Test
    void handle_sellInAboveZero_qualityDecreasesWith1() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("Any other item", 1, 5));

        defaultItemHandler.handle(itemWrapper);

        assertEquals(0, itemWrapper.getSellIn());
        assertEquals(4, itemWrapper.getQuality());
    }

    @Test
    void handle_sellInAboveZero_qualityAtZero_qualityRemainsZero() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("Any other item", 1, 0));

        defaultItemHandler.handle(itemWrapper);

        assertEquals(0, itemWrapper.getSellIn());
        assertEquals(0, itemWrapper.getQuality());
    }

    @Test
    void handle_sellInBelowZero_qualityDecreasesWith2() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("Any other item", 0, 5));

        defaultItemHandler.handle(itemWrapper);

        assertEquals(-1, itemWrapper.getSellIn());
        assertEquals(3, itemWrapper.getQuality());
    }
}
