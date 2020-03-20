package io.namoosori.auction.item.bind;

import io.namoosori.auction.item.entity.IdName;
import io.namoosori.auction.item.proxy.UserProxy;
import io.namoosori.auction.user.UserClient;
import io.namoosori.auction.user.entity.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@Component
@EnableFeignClients(basePackages = "io.namoosori")
public class UserDelegator implements UserProxy {

    private final UserClient userClient;

    public UserDelegator(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public boolean exists(String id) {

        boolean result = true;
        try {
            this.findUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public IdName findUser(String id) {
        User foundUser = userClient.findUser(id);
        return new IdName(foundUser.getId(), foundUser.getName());
    }

}
