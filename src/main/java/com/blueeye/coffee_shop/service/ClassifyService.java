package com.blueeye.coffee_shop.service;

import com.blueeye.coffee_shop.converter.ClassifyConverter;
import com.blueeye.coffee_shop.dto.ClassifyDto;
import com.blueeye.coffee_shop.entity.ClassifyEntity;
import com.blueeye.coffee_shop.repository.ClassifyRepository;
import com.blueeye.coffee_shop.service.IService.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassifyService implements IClassifyService {

    private ClassifyRepository classifyRepository;
    private ClassifyConverter classifyConverter;

    @Autowired
    public ClassifyService (ClassifyRepository classifyRepository, ClassifyConverter classifyConverter){
        this.classifyRepository = classifyRepository;
        this.classifyConverter = classifyConverter;
    }

    @Override
    public List<ClassifyDto> findAll() {
        List<ClassifyDto> dtos = new ArrayList<>();
        List<ClassifyEntity> entities = classifyRepository.findAll();
        for(ClassifyEntity e : entities){
            dtos.add(classifyConverter.toDto(e));
        }
        return dtos;
    }


}
