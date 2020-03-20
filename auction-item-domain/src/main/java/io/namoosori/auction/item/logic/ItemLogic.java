package io.namoosori.auction.item.logic;

import io.namoosori.auction.item.entity.Item;
import io.namoosori.auction.item.lifecycle.StoreLifecycle;
import io.namoosori.auction.item.spec.ItemService;
import io.namoosori.auction.item.store.ItemStore;

import java.util.List;

public class ItemLogic implements ItemService {

    private final ItemStore itemStore;

    public ItemLogic(StoreLifecycle storeLifeCycle) {
        this.itemStore = storeLifeCycle.requestItemStore();
    }

    @Override
    public String registerItem(Item item) {
        itemStore.create(item);
        return item.getId();
    }

    @Override
    public Item findItem(String id) {
        return itemStore.retrieve(id);
    }

    @Override
    public List<Item> findItemsBySeller(String sellerId) {
        return itemStore.retrieveAllSeller(sellerId);
    }
}
