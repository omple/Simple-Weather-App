package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FindCity {

    String cityName = readConsole();
    Gson googleJson = new Gson();
    public FindCity(){}

    public static String readConsole(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter City Name: ");
        String s = scan.nextLine().toLowerCase();

        return s;
    }
    //reading from console with https://www.w3schools.com/java/java_user_input.asp

    /*
    public static void findCityID() throws IOException {
        URL path = FindCity.class.getResource("com\\company\\citylist.json");
        Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(path)));
        System.out.println(reader);
        reader.close();


    }
     */
}
