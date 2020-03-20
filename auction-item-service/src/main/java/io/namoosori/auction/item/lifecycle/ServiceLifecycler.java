package io.namoosori.auction.item.lifecycle;

import io.namoosori.auction.item.logic.ItemLogic;
import io.namoosori.auction.item.spec.ItemService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifecycle {

    private final StoreLifecycle storeLifecycle;

    public ServiceLifecycler(StoreLifecycle storeLifecycle) {
        this.storeLifecycle = storeLifecycle;
    }

    @Override
    public ItemService requestItemService() {
        return new ItemLogic(storeLifecycle);
    }
}
