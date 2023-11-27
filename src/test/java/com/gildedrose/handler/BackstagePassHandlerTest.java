package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemName;
import com.gildedrose.ItemWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassHandlerTest {
    BackstagePassHandler backstagePassHandler = new BackstagePassHandler();

    @Test
    void handle_sellInIs11_qualityIncreases1() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.BACKSTAGE_PASSES, 11, 5));
        backstagePassHandler.handle(itemWrapper);

        assertEquals(6, itemWrapper.getQuality());
        assertEquals(10, itemWrapper.getSellIn());
    }

    @Test
    void handle_qualityIs50_qualityRemainsAt50() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.BACKSTAGE_PASSES, 3, 50));
        backstagePassHandler.handle(itemWrapper);

        assertEquals(50, itemWrapper.getQuality());
        assertEquals(2, itemWrapper.getSellIn());
    }

    @Test
    void handle_sellInGoesBelow0_qualityDropsTo0() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.BACKSTAGE_PASSES, 0, 40));
        backstagePassHandler.handle(itemWrapper);

        assertEquals(0, itemWrapper.getQuality());
        assertEquals(-1, itemWrapper.getSellIn());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 9, 8, 7, 6})
    void handle_sellInIsBetween6And10_qualityIncreases2(int sellIn) {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.BACKSTAGE_PASSES, sellIn, 5));
        backstagePassHandler.handle(itemWrapper);

        assertEquals(7, itemWrapper.getQuality());
        assertEquals(sellIn-1, itemWrapper.getSellIn());
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 4, 3, 2, 1})
    void handle_sellInIsBetween1And5_qualityIncreases3(int sellIn) {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.BACKSTAGE_PASSES, sellIn, 5));
        backstagePassHandler.handle(itemWrapper);

        assertEquals(8, itemWrapper.getQuality());
        assertEquals(sellIn-1, itemWrapper.getSellIn());
    }

}
