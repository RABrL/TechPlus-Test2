package com.example.back.domain.model;

import java.util.Date;

public class Comment {
    private Long id;
    private String content;
    private User user;
    private String queryId;
    private Date createdAt;
    private Boolean deleted = false;

    public Comment(Long id, String content, User user, String queryId) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.queryId = queryId;
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public String getQueryId() {
        return queryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
