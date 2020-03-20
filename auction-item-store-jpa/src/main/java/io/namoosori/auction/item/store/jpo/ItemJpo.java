package io.namoosori.auction.item.store.jpo;

import io.namoosori.auction.item.entity.IdName;
import io.namoosori.auction.item.entity.Item;
import io.namoosori.auction.item.entity.PricePolicy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemJpo {
    //
    @Id
    private String id;
    private String name;
    private String description;
    private String pricePolicyJson;
    private int currentPrice;
    private String sellerId;
    private String sellerJson;

    public ItemJpo(Item item) {
        //
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.pricePolicyJson = item.getPricePolicy().toJson();
        this.currentPrice = item.getCurrentPrice();
        this.sellerId = item.getSeller().getId();
        this.sellerJson = item.getSeller().toJson();
    }

    public Item toDomain() {
        //
        Item item = new Item(this.id);
        item.setName(this.name);
        item.setDescription(this.description);
        item.setPricePolicy(PricePolicy.fromJson(this.pricePolicyJson));
        item.setCurrentPrice(this.currentPrice);
        item.setSeller(IdName.fromJson(this.sellerJson));
        return item;
    }

}