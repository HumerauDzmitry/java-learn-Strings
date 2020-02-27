package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import java.util.*;

public class HighestOccurredCharacterInString {

    public Map<Character, Integer> getMapFromString(@NonNull String str) {
        Map<Character, Integer> map;
        if (!StringUtils.isEmpty(str)) {
            map = new HashMap <Character, Integer>();
           for (int i = 0; i < str.length(); i++) {
               if (map.containsKey(str.charAt(i))) {
                   map.computeIfPresent(str.charAt(i), (k, v) -> v + 1);
               } else {
                   map.put(str.charAt(i), 1);
               }
           }
            return map;
        }
        return Collections.emptyMap();
    }

    public List<Character> getListMostCommonCharacter (Map<Character, Integer> map) {
        if (!map.isEmpty()) {
            Map<Character, Integer> mapResult = new LinkedHashMap<>();
            map.entrySet().stream()
                    .sorted((Comparator<? super Map.Entry<Character, Integer>>) Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .forEachOrdered(x -> mapResult.put(x.getKey(), x.getValue()));

            List <Character> list = new ArrayList <Character>(mapResult.size());

            for (int i = 0; i < mapResult.size(); i++) {
                if (mapResult.values().toArray()[i] == mapResult.values().toArray()[0]) {
                    list.add((Character) mapResult.keySet().toArray()[i]);
                }
            }
            if (list.size() == mapResult.size()) {
                return Collections.EMPTY_LIST;
            } else {
                return list;
            }
        }
        return Collections.EMPTY_LIST;
    }


    public static void main(String[] args) {
        HighestOccurredCharacterInString highestOccurredCharacterInString = new HighestOccurredCharacterInString();
        highestOccurredCharacterInString.printResult("aaaaaaaaaaabbbbbbbcccccdddddddddddddddddddddd");
        highestOccurredCharacterInString.printResult("aaabbbc");
        highestOccurredCharacterInString.printResult("123");
        highestOccurredCharacterInString.printResult(null);
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            if (getListMostCommonCharacter(getMapFromString(str)).isEmpty()) {
                System.out.println(str + " -> нету повторяющихся символов");
            } else {
                System.out.println(str + " -> " + getListMostCommonCharacter(getMapFromString(str)));
            }
        }
    }
}
