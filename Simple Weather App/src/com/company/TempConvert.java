package com.company;

public class TempConvert {
    public static int KToF(float temp){
        return (int) (1.8 * (temp - 273) + 32);
    }
}
