package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String allPosts() {
        return "posts";
    }


    @GetMapping("/posts/{id}")
    public String individualPost() {
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitForm() {
        return "create a new post";
    }
}
