package com.humerau.developer;

import lombok.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateCharacters {

    public Set<Character> getSetDuplicateCharacters(@NonNull String str) {
        Set<Character> setDuplicateCharacters = new TreeSet<Character>();

        int firstOccurrence;
        int lastOccurrence;
        for (int i = 0; i < str.length(); i++) {
            firstOccurrence = str.indexOf(str.charAt(i));
            lastOccurrence = str.lastIndexOf(str.charAt(i));
            if (firstOccurrence != lastOccurrence) {
                setDuplicateCharacters.add(str.charAt(i));
            }
        }
        if (!setDuplicateCharacters.isEmpty()) {
            return setDuplicateCharacters;
        } else {
            return Collections.emptySet();
        }
    }

    public static void main(String[] args) {
        DuplicateCharacters duplicateCharacters = new DuplicateCharacters();
        duplicateCharacters.printResult("qwertye");
        duplicateCharacters.printResult("123456");
        duplicateCharacters.printResult("");
        duplicateCharacters.printResult("Успешный успех");
        duplicateCharacters.getSetDuplicateCharacters(null);
    }

    public void printResult(String str) {
        if (str.isEmpty()) {
            System.out.println("Строка отсутствует");
        } else {
            if (!getSetDuplicateCharacters(str).isEmpty()) {
                System.out.print("Повторяющиеся символы в String \"" + str + "\": ");
                getSetDuplicateCharacters(str).forEach(x -> System.out.print(x + " "));
                System.out.print("\n");
            } else {
                System.out.println("Повторяющиеся символы в String \"" + str + "\" отсутствуют");
            }
        }
    }
}
