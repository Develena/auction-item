package io.namoosori.auction.item.store;

import io.namoosori.auction.item.entity.Item;

import java.util.List;

public interface ItemStore {

    void create(Item item);
    Item retrieve(String id);
    List<Item> retrieveAllSeller(String sellerId);
}
