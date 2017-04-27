package com.demo.spring.controller;

import com.demo.spring.domain.LoginForm;
import com.demo.spring.domain.SearchForm;
import com.demo.spring.domain.User;
import com.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by web on 19/04/17.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("message", "Please fill in all sections of the form");
            return "register";
        }
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(Model model)
    {
        LoginForm user = new LoginForm();
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @Valid @ModelAttribute("user") LoginForm user, BindingResult bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Please fill in all sections of the form");
            return "login";
        }
        if(userService.validateLogin(user)==false)
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Username or Password are incorrect");
            return "login";
        }

        session.setAttribute("login", true);

        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session)
    {
        session.removeAttribute("login");
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchView(Model model)
    {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchText", searchForm);
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute("searchText") SearchForm searchForm)
    {
        List<User> users = userService.searchUsers(searchForm);
        model.addAttribute("searchText", searchForm);
        model.addAttribute("users", users);
        return "search";
    }

    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET)
    public String updateView(Model model, @PathVariable User user)
    {
        model.addAttribute("user", user);

        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET)
//    @ResponseBody
    public String delete(@PathVariable User user)
    {
//        String name = user.getForename()+" "+user.getSurname();

        userService.delete(user);

        return "redirect:/";
    }
}
