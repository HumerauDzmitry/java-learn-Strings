package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class StringContainsAnotherString {

    public int getIndexOfOccurrenceString (@NonNull String fullStr, @NonNull String str) {
        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(fullStr)) {
            if (fullStr.contains(str)) {
                return fullStr.indexOf(str);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StringContainsAnotherString stringContainsAnotherString = new StringContainsAnotherString();
        stringContainsAnotherString.printResult("123456", "345");
        stringContainsAnotherString.printResult("123456", "349");
        stringContainsAnotherString.printResult("", "345");
        stringContainsAnotherString.printResult("123456", "");
    }

    public void printResult (String fullStr, String str) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(fullStr)) {
            System.out.println("Не корректные данные");
        } else {
            System.out.println(fullStr + " - "  + str + " -> " + getIndexOfOccurrenceString(fullStr, str));
        }
    }
}
