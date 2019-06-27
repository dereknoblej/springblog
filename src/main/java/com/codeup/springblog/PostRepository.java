package com.codeup.springblog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findAllByTitleContaining(String title);


    void deletePostByTitleContaining(String t);


}
