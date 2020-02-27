package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import java.util.Optional;

public class Reverse {

    public Optional<String> executeReversString(@NonNull String str) {
        if (!StringUtils.isEmpty(str)) {
            char[] chArr = str.toCharArray();
            char tempChar;
            for (int i = 0; i < (chArr.length) / 2; i++) {
                tempChar = chArr[i];
                chArr[i] = chArr[chArr.length - 1 - i];
                chArr[chArr.length - 1 - i] = tempChar;
            }
            return Optional.of(String.valueOf(chArr));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Reverse reverseIteration = new Reverse();
        reverseIteration.printResult("abcdefg");
        reverseIteration.printResult("123456789");
        reverseIteration.printResult("12345678");
        reverseIteration.printResult("qwerty");
        reverseIteration.printResult("");
    }

    private void printResult(String str) {
        Optional<String> result = executeReversString(str);
        if (result.isEmpty()) {
            System.out.println("Неверное значение");
        } else {
            System.out.println(result.get());
        }
    }
}
