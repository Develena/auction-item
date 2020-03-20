package io.namoosori.auction.item.proxy;

import io.namoosori.auction.item.entity.IdName;

public interface UserProxy {

    boolean exists(String id);
    IdName findUser(String id);
}
