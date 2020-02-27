package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.Optional.*;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class FirstNonRepeatedCharacter {

    public Map<Character, Integer> convertStrToMap(@NonNull String str) {
        Map<Character, Integer> map;
        if (!StringUtils.isEmpty(str)) {
            map = new LinkedHashMap<Character, Integer> ();
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) == null) {
                    map.put(str.charAt(i), 1);
                } else {
                    map.merge((str.charAt(i)), 1, Integer::sum);
                }
            }
            return map;
        }
        return Collections.emptyMap();
    }

    public Optional<Character> getFirstEntry(Map<Character, Integer> map) {
        Map<Character, Integer> tempMap = map.entrySet().stream()
                .filter(x -> (x.getValue()) == 1)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        if (!tempMap.isEmpty()) {
            return of((Character) tempMap.keySet().toArray()[0]);
        } else {
            return empty();
        }
    }


    public static void main(String[] args){
        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
        firstNonRepeatedCharacter.printResult("123451235");
        firstNonRepeatedCharacter.printResult("abracadabra");
        firstNonRepeatedCharacter.printResult(null);
        firstNonRepeatedCharacter.printResult("abcdabcd");
    }

    public void printResult(String str) {
        if (isEmpty(str)) {
            System.out.println("Неверное значение " + str);
        } else {
            Optional<Character> ch = getFirstEntry(convertStrToMap(str));
            if (ch.isPresent()) {
                System.out.println("Первый неповторяющийся в строке \"" + str + "\" символ: '" + ch.get() + "'");
            } else {
                System.out.println("Неповторяющиеся символы в строке \"" + str + "\" отсутствуют");
            }
        }
    }
}
