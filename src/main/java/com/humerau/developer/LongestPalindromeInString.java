package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestPalindromeInString {

    private final static Logger logger = Logger.getLogger(LongestPalindromeInString.class);

    public List getLongestPalindromesInString (@NonNull String str) {
        if (!StringUtils.isEmpty(str)) {
            List <String> list = Stream.of(str.split(" ")).filter(x -> isPalindrome(x)).collect(Collectors.toList());
            list.sort((s1, s2) -> Math.abs(s1.length() - "intelligent".length()) - Math.abs(s2.length() - "intelligent".length()));
            logger.debug("list : " + list);

            List <String> listResult = new ArrayList<String>(list.size());

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() == list.get(0).length()) {
                    listResult.add(list.get(i));
                } else {
                    break;
                }
            }
            logger.debug("listResult : " + listResult);

            if (listResult.size() == 0) {
                return Collections.EMPTY_LIST;
            } else {
                return listResult;
            }
        }
        return Collections.EMPTY_LIST;
    }

    private boolean isPalindrome (String str) {
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
        LongestPalindromeInString longestPalindromeInString = new LongestPalindromeInString();
        longestPalindromeInString.printResult("123456 radar 12344321 lol abc");
        longestPalindromeInString.printResult("");
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            System.out.println(str + " -> " + getLongestPalindromesInString(str));
        }
    }
}
