package io.namoosori.auction.item.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Item {
    //
    private String id;
    private String name;
    private String description;
    private PricePolicy pricePolicy;
    private int currentPrice;
    private IdName seller;

    public Item() {
        //
        this.id = UUID.randomUUID().toString();
    }

    public Item(String id) {
        //
        this();
        this.id = id;
    }

    public boolean isBiddablePrice(int bidPrice) {
        //
        if (bidPrice % pricePolicy.getPriceStep() != 0) {
            return false;
        }

        if (currentPrice >= bidPrice) {
            return false;
        }

        return true;
    }

    public static Item sample() {
        //


        Item sample = new Item();
        sample.setName("MacBook Pro 15\" Touchbar");
        sample.setDescription("2017 Mid");
        sample.setPricePolicy(new PricePolicy(2100000, 50000));
        sample.setSeller(new IdName(UUID.randomUUID().toString(), "Seller#3"));
        return sample;
    }

    public static void main(String[] args) {
        //
        System.out.println((new Gson()).toJson(Item.sample()));
    }

}
