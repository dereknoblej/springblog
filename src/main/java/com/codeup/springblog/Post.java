package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
public class Post {
    @Id @GeneratedValue @Column(columnDefinition = "int(11) unsigned")
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;

    public Post() {
    }
    public Post(int id, String title, String body){
        this.title = title;
        this.body = body;
        this.id = id;
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
}
