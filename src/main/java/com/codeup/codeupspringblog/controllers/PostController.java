package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping(path = "/posts")
    @ResponseBody
    public String allPosts(){
        return "posts index page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String individualPosts(){
        return "view and individual post";
    }
    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String createForm(){
        return "view the form for creating a  post";
    }
    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String submitForm(){
        return "create a new post";
    }
}
