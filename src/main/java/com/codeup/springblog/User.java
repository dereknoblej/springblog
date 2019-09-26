package com.codeup.springblog;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue @Column(columnDefinition = "int(11) unsigned")
    private int id;

    @NotBlank(message = "Must have username.")
    @Column(nullable = false)
    private String username;

    @NotBlank(message = "Must have password")
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @NotBlank(message = "Must have email")
    @Column(nullable = false)
    private String email;

    @Column
    private Double verifyCode;

    @Column(columnDefinition = "Boolean default false")
    private boolean isVerified;

    @OneToMany(mappedBy = "author")
    @JsonBackReference
    private List<Post> posts;

    public User() {
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.password = copy.password;
        this.email = copy.email;
        this.posts = copy.posts;
        this.isVerified = copy.isVerified;
        this.verifyCode = copy.verifyCode;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Double getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(Double verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
