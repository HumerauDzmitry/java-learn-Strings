package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWordsInSentence {

    private static final Logger logger = Logger.getLogger(ReverseWordsInSentence.class);

    public Optional <String> getInvertedWord(@NonNull String str) {

        if (!StringUtils.isEmpty(str)) {
            ArrayList<String> list = (ArrayList<String>) Stream.of(str.split(" ")).collect(Collectors.toList());
            Collections.reverse(list);
            logger.debug(list);
            String joiner = list.stream().collect(Collectors.joining(" "));
            logger.debug(joiner);
            return Optional.of(joiner);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        ReverseWordsInSentence reverseWordsInSentence = new ReverseWordsInSentence();
        reverseWordsInSentence.printResult("abc def 123");
        reverseWordsInSentence.printResult("abc def 123 456");
        reverseWordsInSentence.printResult("");
    }

    public void printResult (String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("Строка пуста");
        } else {
            if (getInvertedWord(str).isPresent()) {
                System.out.println(str + " -> " + getInvertedWord(str).get());
            }
        }
    }
}
