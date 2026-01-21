package com.YoutubeTools.controller;


import com.YoutubeTools.Model.VideoDetails;
import com.YoutubeTools.Service.YoutubeService;
import com.YoutubeTools.Service.thumbnailsservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class YoutubeVideoController {

    private final YoutubeService youtubeService;
    private final thumbnailsservice service;

    @GetMapping("/youtube/video-details")
    public String showVideoForm(){
        return "video-details";
    }

    @PostMapping("/youtube/video-details")
    public String fetchVideoDetails(@RequestParam String videoUrlOrId, Model model){
         String videoId=service.extractvideoid(videoUrlOrId);

         if(videoId==null){
             model.addAttribute("error","Invalid youtube url or id");
             return "video-details";
         }

         VideoDetails details=youtubeService.getVideoDetails(videoId);
         if(details==null){
             model.addAttribute("error","video not found");
         }
         else{
             model.addAttribute("videoDetails",details);
         }
        model.addAttribute("videoUrlOrId",videoUrlOrId);
         return "video-details";
    }
}
