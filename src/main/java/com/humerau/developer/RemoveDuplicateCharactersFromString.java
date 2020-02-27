package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Optional;

public class RemoveDuplicateCharactersFromString {

    private static final Logger logger = Logger.getLogger(RemoveDuplicateCharactersFromString.class);

    public Optional<String> getStringWithoutDuplicateCharacters (@NonNull String str) {
        logger.debug(str);
        if (!StringUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (stringBuilder.indexOf(String.valueOf(str.charAt(i))) == -1) {
                    stringBuilder.append(str.charAt(i));
                }
            }
            logger.debug(Optional.of(stringBuilder.toString()).get());
            return Optional.of(stringBuilder.toString());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        RemoveDuplicateCharactersFromString removeDuplicateCharactersFromString = new RemoveDuplicateCharactersFromString();
        removeDuplicateCharactersFromString.printResult("123123123abcabcabc");
        removeDuplicateCharactersFromString.printResult(null);
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            Optional <String> stringOptional = getStringWithoutDuplicateCharacters(str);
            if (stringOptional.isPresent()) {
                System.out.println(str + " -> " + stringOptional.get());
            }
        }
    }
}
