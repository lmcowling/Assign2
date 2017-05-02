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

    @RequestMapping(value = "/register", method = RequestMethod.GET) //loads the register view
    public String registerView(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST) //adds the user
    public String register(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("message", "Please fill in all sections of the form");
            return "user/register";
        }
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET) //loads the login form view
    public String loginView(Model model)
    {
        LoginForm user = new LoginForm();
        model.addAttribute("user", user);
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST) //logs the user in and creates a session
    public String login(Model model, @Valid @ModelAttribute("user") LoginForm user, BindingResult bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Please fill in all sections of the form");
            return "user/login";
        }
        if(userService.validateLogin(user)==false)
        {
            model.addAttribute("user", user);
            model.addAttribute("message", "Username or Password are incorrect");
            return "user/login";
        }
        session.setAttribute("login", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET) //logs the user out
    public String logout(Model model, HttpSession session)
    {
        session.removeAttribute("login");
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET) //loads the user search view
    public String searchView(Model model)
    {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchText", searchForm);
        return "user/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST) // loads the user search view with the search results
    public String search(Model model, @ModelAttribute("searchText") SearchForm searchForm)
    {
        List<User> users = userService.searchUsers(searchForm);
        model.addAttribute("searchText", searchForm);
        model.addAttribute("users", users);
        return "user/search";
    }

    @RequestMapping(value = "/update/{user}", method = RequestMethod.GET) //loads the user updates view
    public String updateView(Model model, @PathVariable User user)
    {
        model.addAttribute("user", user);
        return "user/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST) //updates the user table
    public String update(@ModelAttribute("user") User user)
    {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{user}", method = RequestMethod.GET) //deletes the user
//    @ResponseBody
    public String delete(@PathVariable User user)
    {
        userService.delete(user);
        return "redirect:/";
    }
}
