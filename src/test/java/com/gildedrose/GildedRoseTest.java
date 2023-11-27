package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_lowersSellInExceptForSulfuras() {
        Item[] items = new Item[] {
            new Item(ItemName.AGED_BRIE, 5, 40),
            new Item(ItemName.SULFURAS, 5, 80),
            new Item(ItemName.BACKSTAGE_PASSES, 5, 20),
            new Item(ItemName.CONJURED, 5, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(5, items[1].sellIn);
        assertEquals(4, items[2].sellIn);
        assertEquals(4, items[3].sellIn);
    }

    @Test
    void updateQuality_SulfurasQualityRemains() {
        Item[] items = new Item[] {
            new Item(ItemName.SULFURAS, 5, 80),
            new Item(ItemName.SULFURAS, -1, 80)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
        assertEquals(80, items[1].quality);
    }

    @Test
    void updateQuality_OtherProduct_QualityDegradesUntilZero() {
        Item[] items = new Item[] {
            new Item("ANY ITEM", 5, 30),
            new Item("ANY ITEM", 4, 0)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(29, items[0].quality);
        assertEquals(0, items[1].quality);
    }

    @Test
    void updateQuality_OtherProduct_QualityDegradesFastIfBeyondSellDate() {
        Item[] items = new Item[] {
            new Item("ANY ITEM", -1, 28),
            new Item("ANY ITEM", 0, 0)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(26, items[0].quality);
        assertEquals(0, items[1].quality);
    }

    @Test
    void updateQuality_BrieAndConcertPass_SellDateIn12Days_QualityEnhancesTo50() {
        Item[] items = new Item[] {
            new Item(ItemName.AGED_BRIE, 12, 49),
            new Item(ItemName.AGED_BRIE, 12, 50),
            new Item(ItemName.BACKSTAGE_PASSES, 12, 49),
            new Item(ItemName.BACKSTAGE_PASSES, 12, 50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, items[0].quality);
        assertEquals(50, items[1].quality);
        assertEquals(50, items[2].quality);
        assertEquals(50, items[3].quality);
    }

    @Test
    void updateQuality_ConcertPass_SellDateDeterminesQualityIncrement() {
        Item[] items = new Item[] {
            new Item(ItemName.BACKSTAGE_PASSES, 10, 20),
            new Item(ItemName.BACKSTAGE_PASSES, 10, 50),
            new Item(ItemName.BACKSTAGE_PASSES, 5, 20),
            new Item(ItemName.BACKSTAGE_PASSES, 5, 50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(50, items[1].quality);
        assertEquals(23, items[2].quality);
        assertEquals(50, items[3].quality);
    }

    @Test
    void updateQuality_SellDatePassed_Brie_QualityRisesUntil50() {
        Item[] items = new Item[] {
            new Item(ItemName.AGED_BRIE, -1, 20),
            new Item(ItemName.AGED_BRIE, -1, 50)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(22, items[0].quality);
        assertEquals(50, items[1].quality);
    }

    @Test
    void updateQuality_SellDatePassed_Pass_QualityBecomes0() {
        Item[] items = new Item[] {
            new Item(ItemName.BACKSTAGE_PASSES, -1, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    void updateQuality_SellDatePassed_Sulfuras_QualityRemains() {
        Item[] items = new Item[] {
            new Item(ItemName.SULFURAS, -1, 80)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, items[0].quality);
    }

    @Test
    void updateQuality_SellDatePassed_Unknown_QualityDegradesFaster() {
        Item[] items = new Item[] {
            new Item("ANY ITEM", -1, 20)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(18, items[0].quality);
    }


    @Test
    void updateQuality_ConjuredProduct_QualityDegradesUntilZero() {
        Item[] items = new Item[] {
            new Item(ItemName.CONJURED, 5, 30)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(28, items[0].quality);
    }

    @Test
    void updateQuality_ConjuredProduct_QualityDegradesFastIfBeyondSellDate() {
        Item[] items = new Item[] {
            new Item(ItemName.CONJURED, -1, 28)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(24, items[0].quality);
    }

}
