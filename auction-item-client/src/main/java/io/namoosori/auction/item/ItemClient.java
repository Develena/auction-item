package io.namoosori.auction.item;

import io.namoosori.auction.item.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="auction-item")
public interface ItemClient {

    @GetMapping(value={"/{id}"})
    public Item findItem(@PathVariable(value="id") String id);

    @GetMapping(value={"/seller/{sellerId}"})
    public List<Item> findItemsBySeller(@PathVariable(value="sellerId")  String sellerId);
}
