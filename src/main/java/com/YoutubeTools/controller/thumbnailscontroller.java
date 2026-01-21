package com.YoutubeTools.controller;


import com.YoutubeTools.Service.thumbnailsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class thumbnailscontroller {

    @Autowired
    thumbnailsservice service;

    @GetMapping("/thumbnail")
    public String thumbnails(){
        return "thumbnails";
    }


    @PostMapping("/get-thumbnail")
    public String showthumbnail(@RequestParam ("videoUrlOrId") String videoUrlOrId, Model model){
        String videoid=service.extractvideoid(videoUrlOrId);
        if(videoid==null){
            model.addAttribute("error","Invalid Youtube URL");
            return "thumbnails";
        }

        String thumbnailurl="https://img.youtube.com/vi/"+videoid+"/maxresdefault.jpg";
        model.addAttribute("thumbnailUrl",thumbnailurl);
        return "thumbnails";
    }
}
