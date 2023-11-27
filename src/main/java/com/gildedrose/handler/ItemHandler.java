package com.gildedrose.handler;

import com.gildedrose.ItemName;
import com.gildedrose.ItemWrapper;

import java.util.HashMap;
import java.util.Map;

public interface ItemHandler {
    void handle(ItemWrapper item);

    Map<String, ItemHandler> handlers = new HashMap<>();
    static ItemHandler forItem(String itemName) {
        String handlerName = getHandlerName(itemName);

        return getHandlerInstance(handlerName);
    }

    private static String getHandlerName(String itemName) {
        if (ItemName.AGED_BRIE.equalsIgnoreCase(itemName))
            return ItemName.AGED_BRIE;
        else if (ItemName.BACKSTAGE_PASSES.equalsIgnoreCase(itemName))
            return ItemName.BACKSTAGE_PASSES;
        else if (ItemName.SULFURAS.equalsIgnoreCase(itemName))
            return ItemName.SULFURAS;
        else if (ItemName.CONJURED.equalsIgnoreCase(itemName))
            return ItemName.CONJURED;
        else
            return "DEFAULT";
    }

    private static ItemHandler getHandlerInstance(String handlerName) {
        if (!handlers.containsKey(handlerName)) {
            if (ItemName.AGED_BRIE.equalsIgnoreCase(handlerName))
                handlers.put(handlerName, new AgedBrieHandler());
            else if (ItemName.BACKSTAGE_PASSES.equalsIgnoreCase(handlerName))
                handlers.put(handlerName, new BackstagePassHandler());
            else if (ItemName.SULFURAS.equalsIgnoreCase(handlerName))
                handlers.put(handlerName, new ConstantQualityItemHandler());
            else if (ItemName.CONJURED.equalsIgnoreCase(handlerName))
                handlers.put(handlerName, new ConjuredItemHandler());
            else
                handlers.put(handlerName, new DefaultItemHandler());
        }
        return handlers.get(handlerName);
    }
}
