package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    ProductDto save(ProductDto dto);
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    void deleteList(Long[] ids);

    List<ProductDto> findAll(Pageable pageable);

    int getTotalItem();
}
