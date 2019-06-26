package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model){
        Post post1 = new Post("Post1", "Post1's body");
        Post post2 = new Post("Post2", "Post2's body");
        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);
        model.addAttribute("postlist", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(Model model){
        Post post = new Post("HelloWorld", "This is a basic post");
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());

        return "posts/index";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "view the form for creating posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public void createPost(){

    }



}
