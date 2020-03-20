package io.namoosori.auction.item.rest;

import io.namoosori.auction.item.entity.Item;
import io.namoosori.auction.item.lifecycle.ServiceLifecycle;
import io.namoosori.auction.item.spec.ItemService;
import io.namoosori.auction.user.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemResource implements ItemService {

    private final ItemService itemService;

    public ItemResource(ServiceLifecycle serviceLifecycle) {
        this.itemService = serviceLifecycle.requestItemService();
    }

    @PostMapping(value={"", "/"})
    public String registerItem(@RequestBody Item item) {
        if(itemService == null) {
            System.out.println("itemService is null");
        } else {
            System.out.println("itemService is not null");
        }
        return itemService.registerItem(item);
    }

    @GetMapping(value={"/{id}"})
    public Item findItem(@PathVariable(value="id") String id) {
        return itemService.findItem(id);
    }

    @GetMapping(value={"/seller/{sellerId}"})
    public List<Item> findItemsBySeller(@PathVariable(value="sellerId")  String sellerId) {
        return itemService.findItemsBySeller(sellerId);
    }
}
