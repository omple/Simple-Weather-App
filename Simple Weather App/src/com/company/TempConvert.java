package com.company;

public class TempConvert {
    public static float KToF(float temp){
        return (float) (1.8 * (temp - 273) + 32);
    }
}
