package com.codeup.springblog;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id @GeneratedValue @Column(columnDefinition = "int(11) unsigned")
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

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
}
