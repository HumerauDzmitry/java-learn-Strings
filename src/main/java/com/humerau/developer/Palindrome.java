package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class Palindrome {

    public boolean isPalindrome (@NonNull String str) {
        if (!StringUtils.isEmpty(str)) {
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.toLowerCase().charAt(i) != str.charAt(str.toLowerCase().length() -1 -i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.printResult("Radar");
        palindrome.printResult("Java");
        palindrome.printResult("");
    }
    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            System.out.println(str + " -> " + isPalindrome(str));
        }
    }
}
