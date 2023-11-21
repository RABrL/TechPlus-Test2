package com.example.back.domain.model;

import java.util.Date;
import java.util.List;

public class Query {
    private String id;
    private String content;
    private String title;
    private String description;
    private User user;
    private List<Comment> comments;
    private Date createdAt;

    public Query(String id, String content, String title, String description, User user, List<Comment> comments) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.description = description;
        this.user = user;
        this.comments = comments;
        this.createdAt = new Date();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
