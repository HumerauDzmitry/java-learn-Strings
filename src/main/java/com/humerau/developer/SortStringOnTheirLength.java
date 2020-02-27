package com.humerau.developer;

import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;
import java.util.Comparator;

public class SortStringOnTheirLength {

    public void printResult (String [] strArr) {
        if (ArrayUtils.isEmpty(strArr)) {
            System.out.println("Пустой массив");
        } else {
            System.out.println(Arrays.toString(getArraySortedBySize(strArr)));
        }
    }

    public String[] getArraySortedBySize (String [] strArr) {
        if (!ArrayUtils.isEmpty(strArr)) {
            String [] tempArr = strArr;
            Arrays.sort(tempArr, new StringLengthComparator());
            return tempArr;
        }
        return null;
    }

    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();
        }
    }

    public static void main(String[] args) {
        SortStringOnTheirLength sortStringOnTheirLength = new SortStringOnTheirLength();
        sortStringOnTheirLength.printResult(new String[]{"123", "123456", "1", "123", "1234"});
        sortStringOnTheirLength.printResult(new String[]{});
    }
}
