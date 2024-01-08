package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.converter.BlogConverter;
import com.blueeye.coffee_shop.dto.BlogDto;
import com.blueeye.coffee_shop.entity.BlogEntity;
import com.blueeye.coffee_shop.repository.BlogRepository;
import com.blueeye.coffee_shop.service.IService.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    private BlogRepository blogRepository;
    private BlogConverter blogConverter;

    @Autowired
    public BlogService(BlogRepository blogRepository, BlogConverter blogConverter) {
        this.blogRepository = blogRepository;
        this.blogConverter = blogConverter;
    }

    @Override
    public BlogDto save(BlogDto blogDto) {
        BlogEntity blogEntity = new BlogEntity();
        if(blogDto.getId()==null){
            blogEntity = blogConverter.toEntity(blogDto);
        }else{
            BlogEntity oldBlogEntity = blogRepository.findById(blogDto.getId()).get();
            blogEntity = blogConverter.toEntity(blogDto, oldBlogEntity);
        }
        return blogConverter.toDto(blogRepository.save(blogEntity));
    }

    @Override
    public List<BlogDto> findAll() {
        List<BlogEntity> entities = blogRepository.findAll();
        List<BlogDto> dtos = new ArrayList<>();
        for(BlogEntity b : entities){
            dtos.add(blogConverter.toDto(b));
        }
        return dtos;
    }

    @Override
    public BlogDto findById(Long id) {
        BlogEntity entity = blogRepository.findById(id).get();
        return blogConverter.toDto(entity);
    }

    @Override
    public void delete(Long[] ids) {

    }

    public List<BlogDto> findAll(Pageable pageable) {
        List<BlogDto> dtos = new ArrayList<>();
        List<BlogEntity> entities = blogRepository.findAll(pageable).getContent();
        for(BlogEntity entity : entities) {
            BlogDto blogDto = blogConverter.toDto(entity);
            dtos.add(blogDto);
        }
        return dtos;
    }

    @Override
    public int getTotalItem() {
        return (int) blogRepository.count();
    }
}
