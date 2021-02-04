package com.andrew.common.controllers;

import com.andrew.common.model.User;
import com.andrew.common.service.RoleService;
import com.andrew.common.service.UserService;
import com.andrew.common.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ModelAndView showUser(Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfo");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(value = "/")
    public String getLoginPage() {
        return "index";
    }

}
