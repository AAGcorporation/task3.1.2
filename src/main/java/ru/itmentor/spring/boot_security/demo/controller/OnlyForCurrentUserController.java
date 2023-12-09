package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmentor.spring.boot_security.demo.security.UsersDetails;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@Controller
public class OnlyForCurrentUserController {

    private final UserService userService;

    @Autowired
    public OnlyForCurrentUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/info")
    public String showUserList(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails userDetails = (UsersDetails) authentication.getPrincipal();
        model.addAttribute("users", userDetails.getUser());
        return "user-info";
    }
}
