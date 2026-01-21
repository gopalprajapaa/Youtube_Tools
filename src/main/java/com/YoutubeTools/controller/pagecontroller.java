package com.YoutubeTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pagecontroller {

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("/video-details")
    public String videodetails(){
        return "video-details";
    }
}
