package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class StringContainsOnlyDigits {


    public boolean isStringContainsOnlyDigits (@NonNull String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            return str.chars().allMatch(x -> Character.isDigit(x));
        }
    }

    public static void main(String[] args) {
        StringContainsOnlyDigits stringContainsOnlyDigits = new StringContainsOnlyDigits();
        stringContainsOnlyDigits.printResult("147852369");
        stringContainsOnlyDigits.printResult("123w456t789");
        stringContainsOnlyDigits.printResult("123,456-789");
        stringContainsOnlyDigits.printResult("");
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            if (isStringContainsOnlyDigits(str)) {
                System.out.println("Строка \"" + str + "\" состоит только из цифр");
            } else {
                System.out.println("Строка \"" + str + "\" состоит не только из цифр");
            }
        }
    }
}
