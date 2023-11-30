package com.blueeye.coffee_shop.service.IService;

import com.blueeye.coffee_shop.dto.ClassifyDto;
import com.blueeye.coffee_shop.entity.ClassifyEntity;

import java.util.List;

public interface IClassifyService {
    List<ClassifyDto> findAll();

}
