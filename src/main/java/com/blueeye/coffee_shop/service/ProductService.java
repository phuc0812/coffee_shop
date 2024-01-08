package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.converter.ProductConverter;
import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.ClassifyEntity;
import com.blueeye.coffee_shop.entity.ProductEntity;
import com.blueeye.coffee_shop.repository.CartRepository;
import com.blueeye.coffee_shop.repository.ClassifyRepository;
import com.blueeye.coffee_shop.repository.ProductRepository;
import com.blueeye.coffee_shop.service.IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;
    private ClassifyRepository classifyRepository;
    private CartRepository cartRepository;
    private ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductConverter productConverter, ClassifyRepository classifyRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.classifyRepository = classifyRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        ClassifyEntity classifyEntity = classifyRepository.findById(dto.getClassifyId()).get();
        ProductEntity productEntity = new ProductEntity();
        if(dto.getId()!=null){
            ProductEntity oldProduct = productRepository.findById(dto.getId()).get();
            oldProduct.setClassify(classifyEntity);
            productEntity = productConverter.toEntity(dto, oldProduct);
        }else{
            productEntity = productConverter.toEntity(dto);
            productEntity.setClassify(classifyEntity);
        }
        return productConverter.toDto(productRepository.save(productEntity));
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> dtos = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll();
        for(ProductEntity e : entities){
            dtos.add(productConverter.toDto(e));
        }
        return dtos;
    }

    @Override
    public ProductDto findById(Long id) {
        return productConverter.toDto(productRepository.findById(id).get());
    }

    @Transactional
    @Override
    public void deleteList(Long[] ids) {
        for(Long id : ids){
            cartRepository.deleteByProductId(id);
            productRepository.deleteById(id);
        }
    }

    public List<ProductDto> findAll(Pageable pageable) {
        List<ProductDto> dtos = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
        for(ProductEntity entity : entities){
            dtos.add(productConverter.toDto(entity));
        }
        return dtos;
    }

    @Override
    public int getTotalItem() {
        return (int) productRepository.count();
    }
}
