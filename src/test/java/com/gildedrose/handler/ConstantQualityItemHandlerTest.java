package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.ItemName;
import com.gildedrose.ItemWrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantQualityItemHandlerTest {
    ConstantQualityItemHandler constantQualityItemHandler = new ConstantQualityItemHandler();

    @Test
    void handle_SellInAndQualityRemainTheSame() {
        ItemWrapper itemWrapper = new ItemWrapper(new Item(ItemName.SULFURAS, 80, 50));

        constantQualityItemHandler.handle(itemWrapper);

        assertEquals(80, itemWrapper.getSellIn());
        assertEquals(50, itemWrapper.getQuality());
    }
}
