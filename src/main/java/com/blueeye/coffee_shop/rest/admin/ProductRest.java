package com.blueeye.coffee_shop.rest.admin;

import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.ClassifyEntity;
import com.blueeye.coffee_shop.entity.ProductEntity;
import com.blueeye.coffee_shop.service.ClassifyService;
import com.blueeye.coffee_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/san-pham")
public class ProductRest {
    private ProductService productService;

    @Autowired
    public ProductRest(ProductService productService, ClassifyService classifyService){
        this.productService = productService;
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto dto){
        return productService.save(dto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto dto){
        return productService.save(dto);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Long[] ids){
        productService.deleteList(ids);
    }
}
