package com.dpavlovich.codewars.codewars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.codewars.com/kata/5263c6999e0f40dee200059d
 */
public class ObservedPinMySolution {

    public static final Map<Character, char[]> adjacentDigits = new HashMap<>();

    static {
        adjacentDigits.put('0', new char[]{'8'});
        adjacentDigits.put('1', new char[]{'2', '4'});
        adjacentDigits.put('2', new char[]{'1', '3', '5'});
        adjacentDigits.put('3', new char[]{'2', '6'});
        adjacentDigits.put('4', new char[]{'1', '5', '7'});
        adjacentDigits.put('5', new char[]{'2', '4', '6', '8'});
        adjacentDigits.put('6', new char[]{'3', '5', '9'});
        adjacentDigits.put('7', new char[]{'4', '8'});
        adjacentDigits.put('8', new char[]{'0', '5', '7', '9'});
        adjacentDigits.put('9', new char[]{'6', '8'});
    }

    public static void main(String[] args) {
        System.out.println(getPINs("1234"));
    }

    public static List<String> getPINs(String observedPin) {
        List<String> pins = new ArrayList<>();
        findPossiblePin(observedPin, 0, new StringBuilder(), pins);
        return pins;
    }

    private static void findPossiblePin(String observedPin,
                                        int index,
                                        StringBuilder possiblePin,
                                        Collection<String> pins) {
        if (index == observedPin.length()) {
            pins.add(possiblePin.toString());
            return;
        }

        char currentChar = observedPin.charAt(index);
        findPossiblePin(observedPin,
                index + 1,
                new StringBuilder(possiblePin).append(currentChar),
                pins);
        for (char it : adjacentDigits.get(currentChar)) {
            findPossiblePin(observedPin,
                    index + 1,
                    new StringBuilder(possiblePin).append(it),
                    pins);
        }
    }

}
