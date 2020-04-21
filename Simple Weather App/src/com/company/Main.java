package com.company;

import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception{
        //weather API that I am using https://openweathermap.org/
        String apiKey = "105e15195f64a14d618ca02d48c5e213";
        String cityID = "1006984"; //East London

        //String urlString = "api.openweathermap.org/data/2.5/weather?id=" + cityID + "&appid=" + apiKey;

        //testing with ISS API to test out API code
        String urlString = "http://api.open-notify.org/iss-now.json";
        System.out.println(urlString);

        // Connect to the URL using java's native library
        URL url = new URL(urlString);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        String country = rootobj.get("message").getAsString(); //just grab the zipcode

        System.out.println(country);

        //code to connect to url and code to convert json object to data from users Ad Infinitum and user2654569, https://stackoverflow.com/a/21964051
    }
}
