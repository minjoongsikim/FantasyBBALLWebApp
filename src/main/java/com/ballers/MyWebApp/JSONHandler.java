package com.ballers.MyWebApp;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHandler {
    public static List<LivePlayer> getLivePlayers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<LivePlayer>  players = Arrays.asList(mapper.readValue
                (new File("/Users/lukechieng/Desktop/MyWebApp/src/main/webapp" +
                        "/web_scraper/Files/current_season_stats.json"), LivePlayer[].class));

        return players;
    }
}
