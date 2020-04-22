package com.company;

import com.google.gson.*;

import java.io.InputStream;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception{
        // weather API that I am using https://openweathermap.org/
        String apiKey = "105e15195f64a14d618ca02d48c5e213";
        String cityID = "1006984"; //East London

        // String urlString = "api.openweathermap.org/data/2.5/weather?id=" + cityID + "&appid=" + apiKey;

        // testing with ISS API to test out API code
        String urlString = "http://api.open-notify.org/iss-now.json";
        System.out.println(urlString);

        // code to connect to url and code to convert json object to data from user Scott, https://stackoverflow.com/a/59279251
        // Connect to the URL using java's native library
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        String jsonFile = new String(is.readAllBytes());

        // Convert to a JSON object to a parsed file
        JsonElement parsedFile = JsonParser.parseString(jsonFile);
        System.out.println(parsedFile);

        JsonObject objectFile = parsedFile.getAsJsonObject();
        System.out.println(objectFile.get("iss_position"));

        Gson gson = new Gson();
    }
}
