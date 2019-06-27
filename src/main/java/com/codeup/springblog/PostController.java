package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }



    @GetMapping("/posts")
    public String posts(Model model){

        model.addAttribute("postlist", postsDao.findAllByTitleContaining("t"));

        return "posts/index";
    }
    @PostMapping("/posts")
    private String deletePost(@RequestParam int id){
        postsDao.delete(id);
        return "redirect:posts";

    }


    @GetMapping("/posts/{id}")
    public String individualPost(Model model){
        Post post = new Post("HelloWorld", "This is a basic post");
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());

        return "posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable int id, Model model){
        Post post = postsDao.findOne(id);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        model.addAttribute("id",post.getId());
        return "posts/editPost";
    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable int id, @RequestParam String title, @RequestParam String body){

        Post postToInsert = new Post(id, title,body);
        postsDao.save(postToInsert);
        return "redirect:posts";
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
