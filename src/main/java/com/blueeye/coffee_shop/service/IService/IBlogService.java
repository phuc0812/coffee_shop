package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.dto.BlogDto;
import com.blueeye.coffee_shop.entity.BlogEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    public BlogDto save(BlogDto blog);
    List<BlogDto> findAll();
    BlogDto findById(Long id);
    void delete(Long[] ids);
    List<BlogDto> findAll(Pageable pageable);

    int getTotalItem();
}
