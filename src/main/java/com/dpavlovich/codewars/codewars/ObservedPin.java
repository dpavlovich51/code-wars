package com.dpavlovich.codewars.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.codewars.com/kata/5263c6999e0f40dee200059d
 */
public class ObservedPin {
    public static List<String> getPINs(String observedPIN) {
        // Define the adjacent digits for each digit
        Map<Character, char[]> adjacentDigits = new HashMap<>();
        adjacentDigits.put('0', new char[] { '8' });
        adjacentDigits.put('1', new char[] { '2', '4' });
        adjacentDigits.put('2', new char[] { '1', '3', '5' });
        adjacentDigits.put('3', new char[] { '2', '6' });
        adjacentDigits.put('4', new char[] { '1', '5', '7' });
        adjacentDigits.put('5', new char[] { '2', '4', '6', '8' });
        adjacentDigits.put('6', new char[] { '3', '5', '9' });
        adjacentDigits.put('7', new char[] { '4', '8' });
        adjacentDigits.put('8', new char[] { '0', '5', '7', '9' });
        adjacentDigits.put('9', new char[] { '6', '8' });

        // Initialize the result list
        List<String> variations = new ArrayList<>();

        // Start with the observed PIN itself
        findVariations("", observedPIN, adjacentDigits, variations);

        return variations;
    }

    private static void findVariations(String prefix,
                                       String remainingPIN,
                                       Map<Character, char[]> adjacentDigits,
                                       List<String> variations) {
        if (remainingPIN.length() == 0) {
            variations.add(prefix);
            return;
        }

        char currentDigit = remainingPIN.charAt(0);
        char[] possibleDigits = adjacentDigits.get(currentDigit);

        for (char digit : possibleDigits) {
            findVariations(prefix + digit, remainingPIN.substring(1), adjacentDigits, variations);
        }

        // Include the observed digit itself as a variation
        findVariations(prefix + currentDigit, remainingPIN.substring(1), adjacentDigits, variations);
    }

    public static void main(String[] args) {
        // Test the getPINs function
        String observedPIN = "11";
        List<String> variations = getPINs(observedPIN);
        System.out.println("Variations for PIN " + observedPIN + ":");
        for (String variation : variations) {
            System.out.println(variation);
        }
    }
}
