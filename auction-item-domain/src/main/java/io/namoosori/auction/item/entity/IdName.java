package io.namoosori.auction.item.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IdName {

    private String id;
    private String name;

    public IdName(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String toJson(){
        return (new Gson().toJson(this));
    }

    public static IdName fromJson(String sellerJson){
        return (new Gson().fromJson(sellerJson, IdName.class));
    }
}
