package ru.gmyrkin.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gmyrkin.crud.model.User;
import ru.gmyrkin.crud.services.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String getAll(ModelMap model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);


        return "users";
    }

}