package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity   // 👈 Required
@Data     // (optional, for Lombok)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String starredArticleLink;

    // Constructors, Getters, Setters
    public User() {}

    public User(String username, String password, String email, String starredArticleLink) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.starredArticleLink = starredArticleLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStarredArticleLink() {
        return starredArticleLink;
    }

    public void setStarredArticleLink(String starredArticleLink) {
        this.starredArticleLink = starredArticleLink;
    }
}
