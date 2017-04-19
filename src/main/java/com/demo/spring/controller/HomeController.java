package com.demo.spring.controller;

import com.demo.spring.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Liam on 19/04/17.
 */

@Controller
public class HomeController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
    public String index(Model model)
    {
        User user = new User();

        user.setForename("Liam");
        user.setSurname("Cowling");
        user.setPassword("test");

        model.addAttribute("user", user);
        return "index";
    }
}

