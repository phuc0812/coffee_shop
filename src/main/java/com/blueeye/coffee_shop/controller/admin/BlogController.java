package com.blueeye.coffee_shop.controller.admin;

import com.blueeye.coffee_shop.dto.BlogDto;
import com.blueeye.coffee_shop.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "blogControllerOfAdmin")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @RequestMapping("/quan-tri/bai-viet/danh-sach")
    public String list(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        BlogDto blog = new BlogDto();
        blog.setPage(page);
        blog.setLimit(limit);
        Pageable pageable = PageRequest.of(page-1,limit);
        blog.setListResult(blogService.findAll(pageable));
        blog.setTotalItem(blogService.getTotalItem());
        blog.setTotalPage((int) Math.ceil((double) blog.getTotalItem()/blog.getLimit()));
        model.addAttribute("blog", blog);
        return "admin/blog/list";
    }

    @RequestMapping("/quan-tri/bai-viet/them-moi")
    public String edit(Model model){
        BlogDto blog = new BlogDto();
        model.addAttribute("blog", blog);
        return "admin/blog/edit";
    }

    @RequestMapping("/quan-tri/bai-viet/chinh-sua")
    public String edit(Model model, @RequestParam("id") Long id){
        BlogDto blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "admin/blog/edit";
    }
}
