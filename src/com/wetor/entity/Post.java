package com.wetor.entity;

import java.util.Date;

/**
 * @author wetor
 */
public class Post {
    private Integer id;
    private String title;
    private String author;
    private Date date;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post(String title, String author, Date date, String content) {
        super();
        this.id = null;
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Post(Integer id, String title, String author, Date date, String content) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Post() {
        super();
    }

    @Override
    public String toString() {
        return "Post:{" + "id:" + id.toString() + "," + "title:\"" + title + "\"," + "author:\"" + author + "\"," + "date:"
                + date.toString() + "," + "content:\"" + content + "\"}";
    }

}