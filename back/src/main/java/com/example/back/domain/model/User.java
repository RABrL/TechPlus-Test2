package com.example.back.domain.model;

public class User {
    private Long id;
    private String name;
    private Boolean deleted = false;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}