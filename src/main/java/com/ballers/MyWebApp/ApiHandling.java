package com.ballers.MyWebApp;
import javax.json.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;



public class ApiHandling {
    public static void main(String args[]) throws IOException {
        URL url = new URL("https://www.fantasybasketballnerd.com/service/draft-projections");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer Response
        String inputLine = in.readLine();

        while ((inputLine != null)) {
            response.append(inputLine);
        }
        in.close();

        JSONObject myResponse = new JsonObject(response.toString()) {
        }
    }



}
