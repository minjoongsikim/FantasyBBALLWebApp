package com.ballers.MyWebApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiHandling {
    public static void main(String args[]) throws IOException {
        URL url = new URL("https://www.fantasybasketballnerd.com/service/draft-projections");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine = in.readLine();
        while ((inputLine != null)) {
            System.out.println(inputLine);
        }
        in.close();
    }



}
