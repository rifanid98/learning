package com.java06_lambda_expression.lesson03_method_reference;

public class StringUtil {
    public static boolean isLowerCase(String s) {
        for(char c: s.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
