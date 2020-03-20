package io.namoosori.auction.item.lifecycle;

import io.namoosori.auction.item.bind.UserDelegator;
import io.namoosori.auction.item.proxy.UserProxy;
import org.springframework.stereotype.Component;

@Component
public class ProxyLifecycler implements ProxyLifecycle {

    private final UserDelegator userDelegator;

    public ProxyLifecycler(UserDelegator userDelegator) {
        this.userDelegator = userDelegator;
    }

    @Override
    public UserProxy requestUserProxy() {
        return userDelegator;
    }
}
