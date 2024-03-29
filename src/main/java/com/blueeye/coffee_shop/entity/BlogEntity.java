package com.blueeye.coffee_shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity extends BaseEntity{
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "thumbnail", columnDefinition = "MEDIUMBLOB")
    private byte[] thumbnail;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;

    public BlogEntity() {
    }

    public BlogEntity(String title, byte[] thumbnail, String description, String content) {
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

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
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
