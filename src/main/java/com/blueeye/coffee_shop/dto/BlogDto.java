package com.blueeye.coffee_shop.dto;

public class BlogDto extends AbstractDto<BlogDto>{
    private String title;
    private String thumbnail;
    private String description;
    private String content;

    public BlogDto() {
    }

    public BlogDto(String title, String thumbnail, String description, String content) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
