package com.blueeye.coffee_shop.controller.admin;

import com.blueeye.coffee_shop.dto.ClassifyDto;
import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.ClassifyEntity;
import com.blueeye.coffee_shop.entity.ProductEntity;
import com.blueeye.coffee_shop.service.ClassifyService;
import com.blueeye.coffee_shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
    private ProductService productService;
    private ClassifyService classifyService;

    @Autowired
    public ProductController(ProductService productService, ClassifyService classifyService){
        this.productService = productService;
        this.classifyService = classifyService;
    }

    @GetMapping("/quan-tri/san-pham/danh-sach")
    public String listProduct(Model model){
        List<ProductDto> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/product/list";
    }

    @GetMapping("/quan-tri/san-pham/chinh-sua")
    public String editProduct(@RequestParam("id") Long id, Model model){
        ProductDto product = productService.findById(id);
        List<ClassifyDto> classifies = classifyService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("classifies", classifies);
        return "admin/product/edit";
    }

    @GetMapping("/quan-tri/san-pham/them-moi")
    public String addProduct(Model model){
        ProductDto product = new ProductDto();
        List<ClassifyDto> classifies = classifyService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("classifies", classifies);
        return "admin/product/edit";
    }
}
