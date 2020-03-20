package io.namoosori.auction.item.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PricePolicy {
    //
    private int startPrice;
    private int priceStep;

    public PricePolicy(int startPrice, int priceStep) {
        //
        this.startPrice = startPrice;
        this.priceStep = priceStep;
    }

    public String toJson() {
        //
        return (new Gson()).toJson(this);
    }

    public static PricePolicy fromJson(String pricePolicyJson) {
        //
        return (new Gson()).fromJson(pricePolicyJson, PricePolicy.class);
    }
}
