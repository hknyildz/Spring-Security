package com.hknyildz.Spring.Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home()
    {
        return "this is home page";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "this is admin page";
    }
}
