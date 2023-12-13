package com.example.democinema.controller;

import com.example.democinema.dto.UserInsertDTO;
import com.example.democinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Principal principal, Model model)  {
        if (principal != null) {
            return "redirect:/";
        }
        UserInsertDTO userInsertDTO = new UserInsertDTO();
        model.addAttribute("user", userInsertDTO);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid UserInsertDTO userInsertDTO) {
        userService.insertUser(userInsertDTO);
        return "redirect:/login";
    }
}
