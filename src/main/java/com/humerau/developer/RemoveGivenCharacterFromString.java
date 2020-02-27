package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import java.util.Optional;

public class RemoveGivenCharacterFromString {

    public Optional<String> getStringWithoutGivenCharacter (@NonNull String str, char ch) {
        if (!StringUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder(str.replaceAll(String.valueOf(ch), ""));
            return Optional.of(stringBuilder.toString());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        RemoveGivenCharacterFromString removeGivenCharacterFromString = new RemoveGivenCharacterFromString();
        removeGivenCharacterFromString.printResult("abcdbef", 'b');
        removeGivenCharacterFromString.printResult(null, 'b');
        removeGivenCharacterFromString.printResult("abcdbef", ' ');
    }

    public void printResult (String str, char ch) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            Optional <String> stringOptional = getStringWithoutGivenCharacter(str, ch);
            stringOptional.ifPresent(s -> System.out.println(str + " - " + ch + " -> " + s));
        }
    }
}
