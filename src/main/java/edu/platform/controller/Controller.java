package edu.platform.controller;

import edu.platform.service.TelegramService;
import edu.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    private UserService userService;
    private TelegramService telegramService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setTelegramService(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @GetMapping("/stat")
    public ModelAndView getStatPage () {
        ModelAndView modelAndView = new ModelAndView("stat");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/stat-test")
    public ModelAndView getStatPageTest () {
        ModelAndView modelAndView = new ModelAndView("stat-test");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/projects")
    public ModelAndView getProjectsPage () {
        return new ModelAndView("projects");
    }

    @PostMapping("/mapForm")
    public String acceptMapForm(@RequestBody String request) {
        return telegramService.sendFormDataToAdmin(request);
    }

    @RequestMapping("/test")
    public String test () {
        telegramService.sendFormDataToAdmin("test");
        return "controller test ok";
    }

//
//    @GetMapping("/getUserInfo/")
//    public String getAllUsersInfo() {
//        return userService.getAllUsersInfo();
//    }
//
//    @GetMapping("/getUserInfo/{login}")
//    public String getUserInfo(@PathVariable String login) {
//        return userService.getUserInfo(login);
//    }
//
//    @GetMapping("/test")
//    public ModelAndView getTestInfo() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("users", userService.getTestInfo());
//        System.out.println("getTestInfo " + userService.getTestInfo());
//        return modelAndView;
//    }

}