package io.namoosori.auction.item.store;

import io.namoosori.auction.item.entity.Item;
import io.namoosori.auction.item.store.jpo.ItemJpo;
import io.namoosori.auction.item.store.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ItemJpaStore implements ItemStore {

    private final ItemRepository itemRepository;

    public ItemJpaStore(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void create(Item item) {
        this.itemRepository.save(new ItemJpo(item));
    }

    @Override
    public Item retrieve(String id) {
        Optional<ItemJpo> itemJpo = this.itemRepository.findById(id);
        if(!itemJpo.isPresent()) {
//            throw Excpetion();
        }
        return itemJpo.get().toDomain();
    }

    @Override
    public List<Item> retrieveAllSeller(String sellerId) {
        List<ItemJpo> itemJpos = this.itemRepository.findAllBySellerId(sellerId);
        return itemJpos.stream().map(ItemJpo::toDomain).collect(Collectors.toList());
    }
}
