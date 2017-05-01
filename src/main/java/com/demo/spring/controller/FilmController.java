package com.demo.spring.controller;

import com.demo.spring.domain.Film;
import com.demo.spring.domain.FilmForm;
import com.demo.spring.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Liam on 27/04/17.
 */

@Controller
@RequestMapping(value = "/film")
public class FilmController
{
    @Autowired
    FilmService filmService;

    @RequestMapping(value = "/addFilm", method = RequestMethod.GET)
    public String addView(Model model)
    {
        Film film = new Film();
        model.addAttribute("film", film);
        return "film/addFilm";
    }

    @RequestMapping(value = "/addFilm", method = RequestMethod.POST)
    public String add(Model model, @Valid @ModelAttribute("film") Film film, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("film", film);
            model.addAttribute("message", "Please fill in all sections of the form");
            return "film/addFilm";
        }
        filmService.save(film);
        return "redirect:/film";
    }

    @RequestMapping(value = "/searchFilm", method = RequestMethod.GET)
    public String searchView(Model model)
    {
        FilmForm filmForm = new FilmForm();
        model.addAttribute("searchText", filmForm);
        return "film/searchFilm";
    }

    @RequestMapping(value = "/searchFilm", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("searchText") FilmForm filmForm)
    {
        List<Film> films = filmService.searchFilms(filmForm);
        model.addAttribute("searchText", filmForm);
        model.addAttribute("films", films);
        return "film/searchFilm";
    }

    @RequestMapping(value = "/updateFilm/{film}", method = RequestMethod.GET)
    public String updateFilmView(Model model, @PathVariable Film film)
    {
        model.addAttribute("film", film);
        return "film/updateFilm";
    }

    @RequestMapping(value = "/updateFilm", method = RequestMethod.POST)
    public String updateFilm(@ModelAttribute("film") Film film)
    {
        filmService.save(film);
        return "redirect:/film";
    }

    @RequestMapping(value = "/deleteFilm/{film}", method = RequestMethod.GET)
    public String delete(@PathVariable Film film)
    {
        filmService.delete(film);
        return "redirect:/film";
    }

    @RequestMapping(value = "/filmDetail/{film}", method = RequestMethod.GET)
    public String loadFilmDetail(Model model, @PathVariable Film film)
    {
        model.addAttribute("film", film);
        return "film/filmDetail";
    }
}
