package ru.gmyrkin.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gmyrkin.crud.model.User;
import ru.gmyrkin.crud.services.UserService;

import java.util.ArrayList;
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
//        model.addAttribute("user", new User(1, "Tim", "123"));
        List<User> users = new ArrayList<>();
        users.add(new User(23, "Dim", "123"));
        users.add(new User(25, "Tim", "456"));
        users.add(new User(20, "Rim", "789"));
        model.addAttribute("admin", users);

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
    @GetMapping("/update/{id}")
    public ModelAndView getUserId (@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("userEdit", userService.getUserId(id));


        return modelAndView;
    }
    @PostMapping("/update/{id}")
    public String updateUser (@ModelAttribute User user, @PathVariable("id") long id){
        User userFromDB = userService.getUserId(id);
        if (userFromDB != null){
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