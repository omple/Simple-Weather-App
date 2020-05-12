package com.company;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DataAPI{

    String location;
    JsonObject weatherFile;
    JsonObject temperature;

    public DataAPI(String zipCode){
        this.location = zipCode;
        this.weatherFile = callAPI();
    }


    public JsonObject callAPI() {
        // weather API that I am using https://openweathermap.org/
        String apiKey = "105e15195f64a14d618ca02d48c5e213";

        //api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}&appid={your api key}
        String urlString = "https://api.openweathermap.org/data/2.5/weather?zip=" + location + "&appid=" + apiKey;
        //System.out.println(urlString);

        // testing with ISS API to test out API code
        //String urlString = "http://api.open-notify.org/iss-now.json";


        // code to connect to url and code to convert json object to data from user Scott, https://stackoverflow.com/a/59279251
        // Connect to the URL using java's native library
        URL url = null;

        try {
            //System.out.println(urlString);
            url = new URL(urlString);
            //System.out.println(url);
            InputStream is = url.openStream();
            String jsonFile = new String(is.readAllBytes());

            // Convert to a JSON object to a parsed file
            JsonElement parsedFile = JsonParser.parseString(jsonFile);
            JsonObject objectFile = parsedFile.getAsJsonObject();

            temperature = objectFile.get("main").getAsJsonObject();

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

    public String getWeatherFile(){
        return String.valueOf(weatherFile);
    }

    public String getTemp(){
        String tempNow = String.valueOf(temperature.get("temp"));
        //System.out.println(tempNow);
        Float converted =Float.parseFloat(tempNow);

        return String.valueOf(TempConvert.KToF(converted));
    }

    public String getWeather(){
        return String.valueOf(weatherFile.get("weather").getAsJsonArray().get(0));
    }

    public String getAreaName(){
        return String.valueOf(weatherFile.get("name"));
    }

}

// example call for looking
// {"coord":{"lon":-85.96,"lat":39.96},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"base":"stations","main":{"temp":280.87,"feels_like":275.13,"temp_min":280.37,"temp_max":281.48,"pressure":1023,"humidity":65},"visibility":16093,"wind":{"speed":5.7,"deg":290},"clouds":{"all":90},"dt":1589219934,"sys":{"type":1,"id":4965,"country":"US","sunrise":1589193124,"sunset":1589244505},"timezone":-14400,"id":0,"name":"Fishers","cod":200}