package com.company;

import java.util.Scanner;

public class CityFind {

    public CityFind(){}

    public static String readConsole(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Zipcode: ");
        String s = scan.nextLine().toLowerCase();

        return s;
        //reading from console with https://www.w3schools.com/java/java_user_input.asp
    }

}
