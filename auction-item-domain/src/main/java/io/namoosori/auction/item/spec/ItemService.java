package io.namoosori.auction.item.spec;

import io.namoosori.auction.item.entity.Item;

import java.util.List;

public interface ItemService {

    String registerItem(Item item);
    Item findItem(String id);
    List<Item> findItemsBySeller(String sellerId);
}
