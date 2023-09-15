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

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
