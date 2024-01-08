package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.dto.CartDto;

import java.util.List;

public interface ICartService {
    List<CartDto> findAllByUserId(Long id);
    CartDto save(CartDto cartDto);
    void delete(Long id);
}
