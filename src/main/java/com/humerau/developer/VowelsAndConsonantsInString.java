package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class VowelsAndConsonantsInString {


    public int[] getVowelsAndConsonantsInString (@NonNull String str) {
        int [] tempInt = new int[4];    //[0]-Vowels;   [1]-Consonants; [2]-Numbers; [3]-Other
        char tempCh;

        for (int i = 0; i < str.length(); i++) {
            if (Character.toString(str.charAt(i)).matches("\\d")) {
                tempInt[2]++;
            } else if (Character.toString(str.charAt(i)).matches("\\w")){
                tempCh = str.toLowerCase().charAt(i);
                if (tempCh == 'a' || tempCh == 'e' || tempCh == 'i' || tempCh == 'o' || tempCh == 'u') {
                    tempInt[0]++;
                } else if (tempCh == '_'){
                    tempInt[3]++;
                } else {
                    tempInt[1]++;
                }
            } else {
                tempInt[3]++;
            }
        }
        return tempInt;
    }

    public static void main(String[] args) {
        VowelsAndConsonantsInString vowelsAndConsonantsInString = new VowelsAndConsonantsInString();
        vowelsAndConsonantsInString.printResult("123456");
        vowelsAndConsonantsInString.printResult(" Abc_def ");
        vowelsAndConsonantsInString.printResult("");
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Пустая строка");
        } else {
            int [] countAarray = getVowelsAndConsonantsInString(str);
            System.out.println("В строке \"" + str + "\"\n" + countAarray[0] + " - гласных;\n"
                    + countAarray[1] + " - согласных;\n" + countAarray[2] + " - цифр;\n" + countAarray[3] + " - других символов;\n");
        }
    }
}
