package com.organization.mvcproject.controller;
import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.ReviewImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ModelAndView review() {

        return new ModelAndView("reviewCreatePage", "command", new ReviewImpl());
    }

    @PostMapping(value = "/addReview")
    public ModelAndView addReview(ReviewImpl review, ModelMap model) {
        if(review.getAuthor().isEmpty()) {
            review.setAuthor("anonymous");
        }

        return new ModelAndView("reviewDetailPage", "submittedReview", review);
    }

    @GetMapping(value = "/gamesLibrary")
    public ModelAndView game() {
        return new ModelAndView("gamesPage", "command", new GameImpl());
    }

	@GetMapping(value="/hello")
    public ModelAndView hello(@RequestParam(defaultValue="World") String name) {
        return new ModelAndView("home");
    }
}