package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.ProductDto;
import com.blueeye.coffee_shop.entity.ProductEntity;
import com.blueeye.coffee_shop.util.ThumbnailUtil;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    private ThumbnailUtil thumbnailUtil = new ThumbnailUtil();
    public ProductEntity toEntity(ProductDto dto, ProductEntity entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setCost(dto.getCost());
        if(dto.getThumbnail()!=null) {
            entity.setThumbnail(thumbnailUtil.toByteArray(dto.getThumbnail()));
        }
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }

    public ProductDto toDto(ProductEntity entity){
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCost(entity.getCost());
        if(entity.getThumbnail()!=null) {
            dto.setThumbnail(thumbnailUtil.toString(entity.getThumbnail()));
        }
        dto.setDescription(entity.getDescription());
        dto.setClassifyId(entity.getClassify().getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto){
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setCost(dto.getCost());
        if(dto.getThumbnail()!=null) {
            entity.setThumbnail(thumbnailUtil.toByteArray(dto.getThumbnail()));
        }
        entity.setDescription(dto.getDescription());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }

}