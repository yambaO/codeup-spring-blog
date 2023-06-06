package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserRepository usersDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.usersDao = usersDao;
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "/login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name = "password") String password){
        password = passwordEncoder.encode(password);
        usersDao.save(new User(username, email, password));
        return "redirect:/posts/create";
    }
    @GetMapping("/profile")
    public String showProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId = user.getId();
        user = usersDao.findUserById(userId);
        model.addAttribute("user", user);
        System.out.println(user.getUsername());
        return "profile";
    }

    @PostMapping("/profile")
    public String changeProfile(@RequestParam(name="email") String email){
        System.out.println("Post mapping hit");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId = user.getId();
        user = usersDao.findUserById(userId);
        user.setEmail(email);
        usersDao.save(user);
        return "redirect:/profile";
    }

}



