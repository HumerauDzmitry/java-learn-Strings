package com.humerau.developer;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import java.util.Optional;

public class ReplaceCharacterToOther {

    private static final Logger logger = Logger.getLogger(ReplaceCharacterToOther.class);

    public Optional<String> getStringWithReplacedCharacters (@NonNull String str, @NonNull String strBefore, @NonNull String strAfter) {
        logger.debug(str + ", '" + strBefore + "' -> '" + strAfter + "'");

        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(strBefore) && !StringUtils.isEmpty(strAfter)) {
            StringBuilder stringBuilder = new StringBuilder(str);
            while (stringBuilder.indexOf(strBefore) > 0) {
                stringBuilder.replace(stringBuilder.indexOf(strBefore), stringBuilder.indexOf(strBefore) + strBefore.length(), strAfter);
            }
            logger.debug(stringBuilder.toString());
            return Optional.of(stringBuilder.toString());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        ReplaceCharacterToOther replaceCharacterToOther = new ReplaceCharacterToOther();
        replaceCharacterToOther.printResult("Java is Great", " ", "%20");
        replaceCharacterToOther.printResult(null, " ", "x");
        replaceCharacterToOther.printResult("Java is Great", null, "null");
    }

    public void printResult (String str, String strBefore, String strAfter) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(strBefore) || StringUtils.isEmpty(strAfter)) {
            System.out.println("неверные данные");
        } else {
            Optional<String> stringOptional = getStringWithReplacedCharacters(str, strBefore, strAfter);
            if (stringOptional.isPresent()) {
                System.out.println(str + " -> " + stringOptional.get());
            }
        }
    }
}
