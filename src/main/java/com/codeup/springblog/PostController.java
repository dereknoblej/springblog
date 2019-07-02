package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }



    @GetMapping("/posts")
    public String posts(Model model){

        model.addAttribute("postlist", postsDao.findAll());

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
    public String create(){
        return "posts/create";
    }



    @PostMapping("/posts/create")
    public String  insert(@RequestParam String title, @RequestParam String body){
        User author = usersDao.findOne(1);
        Post newPost = new Post(title,body, author);
        postsDao.save(newPost);
        return "redirect:/posts";

    }



}
