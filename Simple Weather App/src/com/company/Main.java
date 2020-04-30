package com.company;

import com.google.gson.*;

import java.io.InputStream;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception{
        DataAPI data = new DataAPI("46037");

        System.out.println(data.getWeatherFile());
        JsonElement locationWeather = data.getWeather();
        JsonElement locationTemp = data.getTemp();
        JsonElement locationInfo = data.getAreaName();

        System.out.println(locationTemp);
        System.out.println(locationWeather);
        System.out.println(locationInfo);


    }
}
