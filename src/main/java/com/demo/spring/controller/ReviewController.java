package com.demo.spring.controller;

import com.demo.spring.domain.Review;
import com.demo.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/addReview", method = RequestMethod.GET)
    public String addReview(Model model)
    {
        Review review = new Review();
        model.addAttribute("review", review);
        return "review/addReview";
    }


    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String add(Model model, @Valid @ModelAttribute("review") Review review, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("review", review);
            model.addAttribute("message", "Please fill in all sections of the form");
            return "review/addReview";
        }
        reviewService.save(review);
        return "redirect:/review";
    }



//    @RequestMapping(value = "/updateFilm/{film}", method = RequestMethod.GET)
//    public String updateFilmView(Model model, @PathVariable Film film)
//    {
//        model.addAttribute("film", film);
//        return "film/updateFilm";
//    }
//
//    @RequestMapping(value = "/updateFilm", method = RequestMethod.POST)
//    public String updateFilm(@ModelAttribute("film") Film film)
//    {
//        filmService.save(film);
//        return "redirect:/film";
//    }
//
//    @RequestMapping(value = "/deleteFilm/{film}", method = RequestMethod.GET)
//    public String delete(@PathVariable Film film)
//    {
//        filmService.delete(film);
//        return "redirect:/film";
//    }

}
