package com.andrew.common.controllers;

import com.andrew.common.model.User;
import com.andrew.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView userList() {
        List<User> list = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("listUsers", list);
        return mav;
    }

    @RequestMapping("/newUser")
    public String newUserForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "userForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("customer") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editUser(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

}
