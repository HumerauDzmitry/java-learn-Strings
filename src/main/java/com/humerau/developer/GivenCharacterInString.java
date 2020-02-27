package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import java.util.Optional;

public class GivenCharacterInString {

    public Optional<Integer> getOccurrenceCharacterInString (@NonNull  String str, char ch) {
        if (StringUtils.isEmpty(str) || ch == ' ') {
            return Optional.empty();
        } else if (str.indexOf(ch) == str.lastIndexOf(ch)){
            return Optional.of(1);
        } else {
            StringBuilder stringBuilder = new StringBuilder(str);
            int countOccurrence = 1;
            int indexFirstOccurrence = stringBuilder.toString().indexOf(ch);
            int indexLastOccurrence = stringBuilder.toString().lastIndexOf(ch);;

            while (indexFirstOccurrence < indexLastOccurrence) {
                stringBuilder.delete(0, (indexFirstOccurrence + 1));
                countOccurrence++;
                indexFirstOccurrence = stringBuilder.toString().indexOf(ch);
                indexLastOccurrence = stringBuilder.toString().lastIndexOf(ch);
            }
            return Optional.of(countOccurrence);
        }
    }

    public static void main(String[] args) {
        GivenCharacterInString givenCharacterInString = new GivenCharacterInString();
        givenCharacterInString.printResult("abcdbcdebcdef", 'b');
        givenCharacterInString.printResult("123456234567345678456789", '5');
        givenCharacterInString.printResult("aaaaa", 'a');
        givenCharacterInString.printResult(null, 'a');
        givenCharacterInString.printResult("aaaaa", ' ');
    }

    public void printResult (String str, char ch) {
        if (StringUtils.isEmpty(str) || ch == ' ') {
            System.out.println("Неверное значение");
        } else {
            Optional <Integer> integerOptional = getOccurrenceCharacterInString(str, ch);
            System.out.println("Строка \"" + str + "\" содержит " + integerOptional.get() + " символов \'" + ch + "\'");
        }
    }
}
