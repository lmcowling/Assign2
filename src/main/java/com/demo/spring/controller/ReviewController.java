package com.demo.spring.controller;

import com.demo.spring.domain.Film;
import com.demo.spring.domain.Review;
import com.demo.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Liam on 28/04/17.
 */

@Controller
@RequestMapping(value = "/review")
public class ReviewController
{
    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/addReview/{film}", method = RequestMethod.GET)
    public String addReviewView(Model model, @PathVariable Film film)
    {
        Review review = new Review();
        review.setFilm(film);
        model.addAttribute("review", review);
        return "review/addReview";
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String addFilmReview(Model model, @ModelAttribute("review") Review review)
    {
        reviewService.save(review);
        return "redirect:/film";
    }

}
