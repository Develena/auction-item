package io.namoosori.auction.item.lifecycle;

import io.namoosori.auction.item.store.ItemStore;

public interface StoreLifecycle {

    ItemStore requestItemStore();
}
