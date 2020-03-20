package io.namoosori.auction.item.lifecycle;

import io.namoosori.auction.item.store.ItemStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifecycle {

    private final ItemStore itemStore;

    public StoreLifecycler(ItemStore itemStore) {
        this.itemStore = itemStore;
    }

    @Override
    public ItemStore requestItemStore() {
        return itemStore;
    }
}
