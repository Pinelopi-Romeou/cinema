package com.example.democinema.controller;

import com.example.democinema.dto.UserDTO;
import com.example.democinema.service.UserService;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getUser(Principal principal, Model model) throws EntityNotFoundException {
        UserDTO user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/my-shows")
    public String getMyShows(Principal principal, Model model) throws EntityNotFoundException {
        UserDTO user = userService.getUserByUsername(principal.getName());
        model.addAttribute("shows", user.getLikedShows());
        return "shows";
    }

    @GetMapping("/my-reservations")
    public String getMyReservations(Principal principal, Model model) throws EntityNotFoundException {
        UserDTO user = userService.getUserByUsername(principal.getName());
        model.addAttribute("reservations", user.getReservations());
        return "myReservations";
    }
}