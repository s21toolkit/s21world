package edu.platform.controller;

import edu.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DataController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/getUserInfo/")
    public String getAllUsersInfo() {
        return userService.getAllUsersInfo();
    }

    @GetMapping("/getUserInfo/{login}")
    public String getUserInfo(@PathVariable String login) {
        return userService.getUserInfo(login);
    }

    @GetMapping("/test")
    public String getTestInfo() {
        return userService.getTestInfo();
    }

}