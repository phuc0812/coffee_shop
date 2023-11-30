package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.entity.BlogEntity;
import com.blueeye.coffee_shop.repository.BlogRepository;
import com.blueeye.coffee_shop.service.IService.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogEntity save(BlogEntity blog) {
        return blogRepository.save(blog);
    }
}
