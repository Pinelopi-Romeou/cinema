package com.example.democinema.controller;

import com.example.democinema.dto.UpdatePasswordDTO;
import com.example.democinema.dto.UserInsertDTO;
import com.example.democinema.service.ReservationService;
import com.example.democinema.service.UserService;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserRestController {

    private final UserService userService;
    private final ReservationService reservationService;

    @Autowired
    public UserRestController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @PostMapping("/like-show/{id}")
    public void likeShow(Principal principal, @PathVariable("id") Long id) throws EntityNotFoundException {
        userService.likeShow(principal.getName(), id);
    }

    @PostMapping("/reserve/{id}")
    public void reserve(Principal principal, @PathVariable("id") Long id) throws EntityNotFoundException {
        reservationService.createReservation(principal.getName(), id);
    }

    @PutMapping("/password")
    public void updatePassword(Principal principal, @RequestBody UpdatePasswordDTO updatePasswordDTO) throws EntityNotFoundException {
        userService.updatePassword(principal.getName(), updatePasswordDTO);
    }
}
