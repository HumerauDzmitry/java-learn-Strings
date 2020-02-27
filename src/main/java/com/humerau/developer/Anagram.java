package com.humerau.developer;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        char[] ch1 = s1.toLowerCase().replaceAll(" ", "").toCharArray();
        char[] ch2 = s2.toLowerCase().replaceAll(" ", "").toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for (int i = 0; i < s1.length(); i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        anagram.printResult("qwer", "dfg");
        anagram.printResult("Успешный успхе", "усПеШнЫйУсПеХ");
        anagram.printResult("qwerty", null);
    }

    public void printResult(String str1, String str2) {
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
            System.out.println("Не корректные данные: str1 - \"" + str1 + "\", str2 - \"" + str2 + "\"");
        } else {
            if (isAnagram(str1, str2)) {
                System.out.println("Строки \"" + str1 + "\" и \"" + str2 + "\" являются анаграмами");
            } else {
                System.out.println("Строки \"" + str1 + "\" и \"" + str2 + "\" не являются анаграмами");
            }
        }
    }
}
