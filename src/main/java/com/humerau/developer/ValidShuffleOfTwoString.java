package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class ValidShuffleOfTwoString {
    private static final Logger logger = Logger.getLogger(ValidShuffleOfTwoString.class);

    public boolean isValidShuffleOfTwoString(@NonNull String str1, @NonNull String str2, @NonNull String strFull) {
        logger.debug(str1 + " <--> " + str2 + " == " + strFull);
        if (!StringUtils.isEmpty(str1) && !StringUtils.isEmpty(str2) && !StringUtils.isEmpty(strFull)) {
            StringBuilder stringBuilder1 = new StringBuilder(str1);
            StringBuilder stringBuilder2 = new StringBuilder(str2);

            if (str1.length() + str2.length() == strFull.length()) {
                for (int i = 0; i < strFull.length(); i++) {

                    if ((stringBuilder1.length() > 0 && stringBuilder2.length() > 0 && strFull.charAt(i) == stringBuilder1.charAt(0)) && (strFull.charAt(i) == stringBuilder2.charAt(0))) {

                        if (strFull.substring(i, i + 2).equals(stringBuilder1.substring(0, 2))) {
                            stringBuilder1.deleteCharAt(0);
                            logger.debug(stringBuilder1 + " - stringBuilder1*");
                        } else if (strFull.substring(i, i + 2).equals(stringBuilder2.substring(0, 2))){
                            stringBuilder2.deleteCharAt(0);
                            logger.debug(stringBuilder2 + " - stringBuilder2*");
                        } else {
                            logger.debug(">2 совпадений подрят");
                        }
                    } else if (stringBuilder1.length() != 0 && strFull.charAt(i) == stringBuilder1.charAt(0)) {
                        stringBuilder1.deleteCharAt(0);
                        logger.debug(stringBuilder1 + " - stringBuilder1");
                    } else if (stringBuilder2.length() != 0 && strFull.charAt(i) == stringBuilder2.charAt(0)) {
                        stringBuilder2.deleteCharAt(0);
                        logger.debug(stringBuilder2 + " - stringBuilder2");
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidShuffleOfTwoString validShuffleOfTwoString = new ValidShuffleOfTwoString();
        validShuffleOfTwoString.printResult("a2bc", "123", "a1232bc");
        validShuffleOfTwoString.printResult("a2bc", "123", "a12bc23");
        validShuffleOfTwoString.printResult("123", "abc", "a12bc3");
        validShuffleOfTwoString.printResult("1369", "2458", "12364589");
    }

    public void printResult(@NonNull String str1, @NonNull String str2, @NonNull String strFull) {
        if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2) && StringUtils.isEmpty(strFull)) {
            System.out.println("Строка пуста");
        } else {
            System.out.println(str1 + " + " + str2 + " = " + strFull + " -> " + isValidShuffleOfTwoString(str1, str2, strFull));
        }
    }
}
