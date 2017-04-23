package com.manivchuk.controllers;

import com.manivchuk.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Lenovo on 28.03.2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView main(HttpSession session){
       // WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
       // return new ModelAndView("main", "user", user);
        if(bindingResult.hasErrors()){
            return "login";
        }
        model.addAttribute("user", user);
        //return "main";
        return "user_index";

    }
    @RequestMapping(value = "/failed", method = RequestMethod.GET)
    public ModelAndView failed(){
        return new ModelAndView("login-failed", "message", "Login failed!");
    }

    @RequestMapping(value = "/addLine", method = RequestMethod.GET)
    public String addLine(){
        return "addLine";
    }

    @RequestMapping(value = "/main_index", method = RequestMethod.GET)
    public String main_page(){
        return "user_index";
    }


    // !!!!!!!!!!!!!!!!!!!!===================!!!!!!!!!!!!!!!!!!!!
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user){
        ModelAndView model = new ModelAndView();
        if(user != null){
            model.addObject("errorMsg", user.getName() + " у вас нет доступа к этой странице.");
        } else{
            model.addObject("errorMsg", "У вас нет доступа к этой странице");
        }
        model.setViewName("/content/accessDenied");
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String mainPage(){
        //return "/content/user";
        return "user_index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(){
        //return "/content/admin";
        return "admin_index";
    }
    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error){

        ModelAndView model = new ModelAndView();
        if(error != null){
            model.addObject("error", "Invalid username or password");
        }

        model.setViewName("login");

        return model;
    }
}
