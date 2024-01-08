package com.blueeye.coffee_shop.rest.admin;

import com.blueeye.coffee_shop.dto.BlogDto;
import com.blueeye.coffee_shop.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogRest {
    private BlogService blogService;

    @Autowired
    public BlogRest(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/api/bai-viet")
    public BlogDto addBlog(@RequestBody BlogDto blogDto){
        return blogService.save(blogDto);
    }

    @PutMapping("/api/bai-viet")
    public BlogDto updateBlog(@RequestBody BlogDto blogDto){
        return blogService.save(blogDto);
    }

    @DeleteMapping("/api/bai-viet")
    public void deleteBlog(Long[] ids){
        blogService.delete(ids);
    }
}
