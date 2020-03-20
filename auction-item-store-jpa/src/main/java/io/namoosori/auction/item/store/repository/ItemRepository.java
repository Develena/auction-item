package io.namoosori.auction.item.store.repository;

import io.namoosori.auction.item.store.jpo.ItemJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemJpo, String> {

    List<ItemJpo> findAllBySellerId(String sellerId);
}
