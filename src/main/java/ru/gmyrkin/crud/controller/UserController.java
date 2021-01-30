package ru.gmyrkin.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.gmyrkin.crud.model.User;
import ru.gmyrkin.crud.services.UserService;

import java.util.List;

@Controller
//@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired (required = true)
   // @Qualifier (value = "userService")
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping("/test")
    public String testUser (ModelMap model){
        model.addAttribute("user", new User(1, "Tim", "123"));

        return "test";
    }

    @GetMapping(value = "/user")
    public String listUsers (ModelMap model) {
       // model.addAttribute("user", new User(1,"Tim","123"));
        model.addAttribute("listUser",userService.getAllUser());

        return "user";
    }

    @PostMapping("/add")
    public String addUser (@ModelAttribute User user){
        if (user.getId() == 0){
             userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/user";
    }
    @PostMapping("/update/{id}")
    public String getUserId (@PathVariable("id") long id){
        User user = userService.getUserId(id);
        if (user != null){
            userService.updateUser(user);
        }

        return "redirect:/user";
    }
    @GetMapping ("/remove/{id}")
    public String deleteUser (@PathVariable("id") long id){
        User userFind = userService.getUserId(id);
        if (userFind != null){
            userService.deleteUser(userFind);
        }

        return "redirect:/user";
    }

}