package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.entity.ShopEntity;
import com.blueeye.coffee_shop.repository.ShopRepository;
import com.blueeye.coffee_shop.service.IService.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService implements IShopService {
    private ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }

    @Override
    public ShopEntity save(ShopEntity shop) {
        return shopRepository.save(shop);
    }
}
