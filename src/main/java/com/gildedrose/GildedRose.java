package com.gildedrose;

import com.gildedrose.handler.*;

import java.util.Arrays;
import java.util.List;

public class GildedRose {
    private final List<ItemWrapper> items;

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items)
            .map(ItemWrapper::new)
            .toList();
    }

    public void updateQuality() {
        for (ItemWrapper item : items) {
            ItemHandler itemHandler = ItemHandler.forItem(item.getName());
            itemHandler.handle(item);
        }
    }
}
