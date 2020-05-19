package com.company;

import javax.lang.model.util.Types;
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

    public static Boolean isFormated(String zipCode){
        String stringDigit = "0123456789";

        if (zipCode.length() == 5){
            for(char i: zipCode.toCharArray()){
                // Character.toString from https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#toString-char-
                if (!stringDigit.contains(Character.toString(i))){
                    return false;
                }
            } // got char array from https://stackoverflow.com/a/2451660
        }else{
            return false;
        }
        return true;
    }

}
