package com.company;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DataAPI {
    public static JsonObject callAPI(){
        // weather API that I am using https://openweathermap.org/
        String apiKey = "105e15195f64a14d618ca02d48c5e213";
        String cityID = "1006984"; //East London

        // String urlString = "api.openweathermap.org/data/2.5/weather?id=" + cityID + "&appid=" + apiKey;
        // System.out.println(urlString);

        // testing with ISS API to test out API code
        String urlString = "http://api.open-notify.org/iss-now.json";


        // code to connect to url and code to convert json object to data from user Scott, https://stackoverflow.com/a/59279251
        // Connect to the URL using java's native library
        URL url = null;
        try {
            url = new URL(urlString);
            InputStream is = url.openStream();
            String jsonFile = new String(is.readAllBytes());

            // Convert to a JSON object to a parsed file
            JsonElement parsedFile = JsonParser.parseString(jsonFile);
            JsonObject objectFile = parsedFile.getAsJsonObject();

            return objectFile;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(parsedFile);
        //System.out.println(objectFile.get("iss_position"));

        return null;
    }
}
