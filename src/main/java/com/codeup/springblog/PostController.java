package com.codeup.springblog;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }



    @GetMapping("/posts")
    public String posts(Model model){

        model.addAttribute("postlist", postsDao.findAll());
        model.addAttribute("mailgun", new Mailgun());

        return "posts/index";
    }

    @PostMapping("/posts")
    private String deletePost(@RequestParam(name="id") int id){
        System.out.println(id);
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
        System.out.println(post.getAuthor());
        model.addAttribute("post", post);

        return "posts/editPost";
    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        Post oldPost = postsDao.findOne(post.getId());
        post.setAuthor(oldPost.getAuthor());
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }



    @PostMapping("/posts/create")
    public String  insert(@Valid Post post, Errors validation, Model model){
        if(validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "/posts/create";
        }

       User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setAuthor(author);
        postsDao.save(post);
        emailService.prepareAndSend(post,post.getTitle(),post.getBody());
        return "redirect:/posts";

    }



}
