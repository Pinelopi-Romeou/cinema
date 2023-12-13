package com.example.democinema.controller;

import com.example.democinema.dto.ReservationDTO;
import com.example.democinema.dto.UserDTO;
import com.example.democinema.service.ReservationService;
import com.example.democinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private final ReservationService reservationService;
    private final UserService userService;

    @Autowired
    public AdminController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String getAllUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/reservations")
    public String getAllReservations(Model model) {
        List<ReservationDTO> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations";
    }
}
