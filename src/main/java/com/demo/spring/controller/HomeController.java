package com.demo.spring.controller;

import com.demo.spring.domain.Film;
import com.demo.spring.domain.User;
import com.demo.spring.service.FilmService;
import com.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Liam on 19/04/17.
 */

@Controller
public class HomeController
{
    @Autowired
    UserService userService;

    @Autowired
    FilmService filmService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session)
    {
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "index";
    }

    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public String filmIndex(Model model, HttpSession session)
    {
        if(session.getAttribute("login")==null)
        {
            return "redirect:/user/login";
        }

        List<Film> films = filmService.findAll();

        model.addAttribute("films", films);

        return "film/indexFilm";
    }
}

