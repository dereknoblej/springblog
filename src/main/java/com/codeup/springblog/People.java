package com.codeup.springblog;

import javax.persistence.*;

@Entity @Table(name = "People")
public class People {
    @Id
    @Column(columnDefinition = "int(11) unsigned")
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2)
    private String reside_state;



}
