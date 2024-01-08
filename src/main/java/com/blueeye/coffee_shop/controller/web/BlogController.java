package com.blueeye.coffee_shop.controller.web;

import com.blueeye.coffee_shop.dto.BlogDto;
import com.blueeye.coffee_shop.service.BlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "blogControllerOfWeb")
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @RequestMapping("/bai-viet")
    public String listBlog(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        BlogDto blog = new BlogDto();
        blog.setPage(page);
        blog.setLimit(limit);
        Pageable pageable = PageRequest.of(page-1,limit);
        blog.setListResult(blogService.findAll(pageable));
        blog.setTotalItem(blogService.getTotalItem());
        blog.setTotalPage((int) Math.ceil((double) blog.getTotalItem()/blog.getLimit()));
        model.addAttribute("blog", blog);
        return "web/blog/list";
    }

    @RequestMapping("/bai-viet/chi-tiet")
    public String detailBlog(@RequestParam("id") Long id, Model model){
        BlogDto blogDto = blogService.findById(id);
        model.addAttribute("blog", blogDto);
        return "web/blog/detail";
    }
}
