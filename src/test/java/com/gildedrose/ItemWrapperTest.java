package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemWrapperTest {

    @Test
    void getQuality() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 4));
        assertEquals(4, itemWrapper.getQuality());
    }

    @Test
    void getSellIn() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 4));
        assertEquals(5, itemWrapper.getSellIn());
    }

    @Test
    void increaseQuality_qualityBelow50_increasesQuality() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 49));
        itemWrapper.increaseQuality();
        assertEquals(50, itemWrapper.getQuality());
    }

    @Test
    void increaseQuality_qualityIs50_qualityRemains50() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 50));
        itemWrapper.increaseQuality();
        assertEquals(50, itemWrapper.getQuality());
    }

    @Test
    void decreaseQuality_qualityAbove0_decreasesQuality() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 1));
        itemWrapper.decreaseQuality();
        assertEquals(0, itemWrapper.getQuality());
    }

    @Test
    void decreaseQuality_qualityIs0_qualityRemains0() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 0));
        itemWrapper.decreaseQuality();
        assertEquals(0, itemWrapper.getQuality());
    }

    @Test
    void decreaseSellIn_sellInDecreases() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item("itemName", 5, 0));
        itemWrapper.decreaseSellIn();
        assertEquals(4, itemWrapper.getSellIn());
    }
}
