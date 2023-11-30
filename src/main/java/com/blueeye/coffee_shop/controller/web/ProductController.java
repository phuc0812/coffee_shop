package com.blueeye.coffee_shop.controller.web;

import com.blueeye.coffee_shop.dto.ClassifyDto;
import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.service.ClassifyService;
import com.blueeye.coffee_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller(value = "productControllerOfWeb")
public class ProductController {

    private ProductService productService;
    private ClassifyService classifyService;

    @Autowired
    public ProductController(ProductService productService, ClassifyService classifyService){
        this.productService = productService;
        this.classifyService = classifyService;
    }

    @GetMapping("/thuc-don")
    public String menu(Model model){
        List<ProductDto> products = productService.findAll();
        List<ClassifyDto> classifies = classifyService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("classifies", classifies);
        return "web/product/menu";
    }
}
