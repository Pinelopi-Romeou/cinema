package com.example.democinema.controller;

import com.example.democinema.authentication.CustomAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

    @Controller
    public class LoginController {

        @GetMapping("/login")
        public String login(Principal principal, HttpServletRequest request) {
            String referer = request.getHeader("Referer");
            request.getSession().setAttribute(CustomAuthenticationSuccessHandler.REDIRECT_URL, referer);

            return principal == null ? "login" : "redirect:/";
        }
    }
