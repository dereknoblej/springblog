package com.codeup.springblog;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Posts")
public class Post {
    @Id @GeneratedValue @Column(columnDefinition = "int(11) unsigned")
    private int id;

    @NotBlank(message = "A post must have a title.")
    @Size(min = 3, message = "A title must be at least 3 characters long.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Post must have a body.")
    @Column(nullable = false)
    private String body;
    @ManyToOne
    private User author;

    public Post() {
    }
    public Post(int id, String title, String body){
        this.title = title;
        this.body = body;
        this.id = id;
    }
    public Post(String title, String body, User author){
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post(int id, String title, String body, User author){
        this.title = title;
        this.body = body;
        this.id = id;
        this.author = author;
    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
