package com.codeup.springblog;

import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {


    Boolean findById(int id);

    User findByUsername(String username);
}