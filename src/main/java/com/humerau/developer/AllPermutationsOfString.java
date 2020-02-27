package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import java.util.*;

public class AllPermutationsOfString {

    private final static Logger logger = Logger.getLogger(AllPermutationsOfString.class);
    private Set<String> allStringPermutations = new TreeSet<>();

    public void permutations(@NonNull String str) {
        allStringPermutations.clear();
        permutations(StringUtils.EMPTY, str);
    }

    private void permutations(String prefix, String str) {
        if (str.length() == 0 && prefix.length() != 0) {
            allStringPermutations.add(prefix);
            logger.debug("prefix: " + prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String leftPartString = prefix + str.charAt(i);
                String rightPartString = str.substring(0, i) + str.substring(i + 1, str.length());

                permutations(leftPartString, rightPartString);
            }
        }
    }

    public static void main(String[] args) {
        AllPermutationsOfString allPermutationsOfString = new AllPermutationsOfString();
        allPermutationsOfString.printResult("12345");
        allPermutationsOfString.printResult("1234");
        allPermutationsOfString.printResult("123");
        allPermutationsOfString.printResult("");
        allPermutationsOfString.permutations(null);
    }

    public Set<String> getAllStringPermutations() {return allStringPermutations;}

    public void printResult(String str) {
        if (!StringUtils.isEmpty(str)) {
            permutations(str);
            System.out.println(allStringPermutations);
        } else {
            System.out.println("String is empty");
        }
    }
}
