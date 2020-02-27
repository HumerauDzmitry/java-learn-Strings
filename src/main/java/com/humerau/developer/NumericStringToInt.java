package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Optional;

public class NumericStringToInt {
    private static final Logger logger = Logger.getLogger(NumericStringToInt.class);

    public Optional<Integer> convertNumericStringToInt (@NonNull String str) throws NumberFormatException {
        if (!StringUtils.isEmpty(str)) {
            try {
                return Optional.of(Integer.parseInt(str));
            } catch (NumberFormatException ex){
                logger.debug(ex);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        NumericStringToInt numericStringToInt = new NumericStringToInt();
        numericStringToInt.printResult("123456");
        numericStringToInt.printResult("-123456");
        numericStringToInt.printResult("One");
        numericStringToInt.printResult("");
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            Optional<Integer> integer = convertNumericStringToInt(str);
            if (integer.isPresent()) {
                System.out.println(str + " -> " + integer.get());
            } else {
                System.out.println(str + " -> Строка состоит не только из цифр");
            }
        }
    }
}
