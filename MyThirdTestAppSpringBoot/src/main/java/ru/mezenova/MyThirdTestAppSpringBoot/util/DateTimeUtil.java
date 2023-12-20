package ru.mezenova.MyThirdTestAppSpringBoot.util;

import java.text.SimpleDateFormat;

public class DateTimeUtil {
    public static SimpleDateFormat getCustomFormatFormat(){
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }
}
