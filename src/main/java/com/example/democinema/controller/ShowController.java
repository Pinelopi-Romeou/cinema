package com.example.democinema.controller;

import com.example.democinema.dto.ShowDTO;
import com.example.democinema.service.ShowService;
import com.example.democinema.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShowController {

    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/shows")
    public String getAllShows(Model model) {
        List<ShowDTO> shows = showService.getAllShows();
        model.addAttribute("shows", shows);
        return "shows";
    }

    @GetMapping("/show/{id}")
    public String getShow(@PathVariable Long id, Model model) throws EntityNotFoundException {
        ShowDTO show = showService.getShowById(id);
        model.addAttribute("show", show);
        return "show";
    }

}
