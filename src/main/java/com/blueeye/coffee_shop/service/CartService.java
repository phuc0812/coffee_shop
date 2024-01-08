package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.converter.CartConverter;
import com.blueeye.coffee_shop.dto.CartDto;
import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.CartEntity;
import com.blueeye.coffee_shop.entity.ProductEntity;
import com.blueeye.coffee_shop.entity.UserEntity;
import com.blueeye.coffee_shop.repository.CartRepository;
import com.blueeye.coffee_shop.repository.ProductRepository;
import com.blueeye.coffee_shop.repository.UserRepository;
import com.blueeye.coffee_shop.service.IService.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CartConverter cartConverter;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository, CartConverter cartConverter){
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartConverter = cartConverter;
    }

    @Override
    public List<CartDto> findAllByUserId(Long id) {
        List<CartEntity> cartEntities = cartRepository.findAllByUserID(id);
        List<CartDto> cartDtos = new ArrayList<>();
        for(CartEntity c : cartEntities){
            cartDtos.add(cartConverter.toDto(c));
        }
        return cartDtos;
    }

    @Override
    public CartDto save(CartDto cartDto) {
        ProductEntity productEntity = productRepository.findById(cartDto.getProductId()).get();
        UserEntity userEntity = userRepository.findById(cartDto.getUserId()).get();
        CartEntity cartEntity = cartRepository.findByProductIdAndUserId(cartDto.getProductId(), cartDto.getUserId());
        if(cartEntity!=null){
            cartEntity.setQuantity(cartDto.getQuantity() + cartEntity.getQuantity());
        }else{
            cartEntity = cartConverter.toEntity(cartDto);
            cartEntity.setProduct(productEntity);
            cartEntity.setUser(userEntity);
        }
        return cartConverter.toDto(cartRepository.save(cartEntity));
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }
}
