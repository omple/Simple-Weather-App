package com.company;

import com.google.gson.*;

import java.io.InputStream;
import java.net.*;

public class Main {

    public static void main(String[] args){

        GUI gui = new GUI();
        gui.start();
/*
        try{
            String locationZip = CityFind.readConsole();

            DataAPI data = new DataAPI(locationZip);

            System.out.println(data.getWeatherFile());
            JsonElement locationWeather = data.getWeather();
            JsonElement locationTemp = data.getTemp();
            JsonElement locationInfo = data.getAreaName();

            System.out.println(locationTemp);
            System.out.println(locationWeather);
            System.out.println(locationInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/


    }
}
