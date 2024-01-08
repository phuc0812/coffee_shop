package com.blueeye.coffee_shop.converter;

import com.blueeye.coffee_shop.dto.BlogDto;
import com.blueeye.coffee_shop.entity.BlogEntity;
import com.blueeye.coffee_shop.util.ThumbnailUtil;
import org.springframework.stereotype.Component;

@Component
public class BlogConverter {

    private ThumbnailUtil thumbnailUtil = new ThumbnailUtil();

    public BlogDto toDto(BlogEntity entity) {
        BlogDto dto = new BlogDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        if(entity.getThumbnail()!=null){
            dto.setThumbnail(thumbnailUtil.toString(entity.getThumbnail()));
        }
        return dto;
    }

    public BlogEntity toEntity(BlogDto dto) {
        BlogEntity entity = new BlogEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        if(dto.getThumbnail()!=null){
            entity.setThumbnail(thumbnailUtil.toByteArray(dto.getThumbnail()));
        }
        return entity;
    }

    public BlogEntity toEntity(BlogDto dto, BlogEntity entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        if(dto.getThumbnail()!=null){
            entity.setThumbnail(thumbnailUtil.toByteArray(dto.getThumbnail()));
        }
        return entity;
    }
}
