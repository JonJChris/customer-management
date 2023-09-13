package com.management.customer.utils;

import java.util.Objects;

public class StringUtils {

    public static boolean isNullOrEmptyString(String stringVal){
       return stringVal == null || stringVal.isBlank();
    }
    public static boolean isNullOrEmptyInteger(Integer integerVal){
       return  integerVal == null || integerVal <= 0;
    }
    public static boolean isNullOrEmptyLong(Long longVal){
        return  longVal == null || longVal <= 0;
    }


}
