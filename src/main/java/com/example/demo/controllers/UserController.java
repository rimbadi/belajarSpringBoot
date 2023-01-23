package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("user", userServices.getAll());
        return "user/user-index";
    }

    @GetMapping(value = {"form"})
    public String create(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("save")
    public String save(User user){
        Boolean result;

        result = userServices.save(user);
        user.setId(userServices.findByEmail(user.getEmail()));
        return "redirect:/user";
    }
}
