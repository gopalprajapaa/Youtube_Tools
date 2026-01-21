package com.YoutubeTools.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {
    private String id;
    private String channelTitle;
    private String title;
    private List<String> tags;
}
