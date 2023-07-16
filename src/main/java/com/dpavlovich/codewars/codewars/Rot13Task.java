package com.dpavlovich.codewars.codewars;

/**
 * <a href="https://www.codewars.com/kata/52223df9e8f98c7aa7000062/solutions/java">source task</a>
 */
public class Rot13Task {

    private static final int CAPITAL_A_VALUE = 'A';
    private static final int CAPITAL_Z_VALUE = 'Z';
    private static final int CAPITAL_DIFF_VALUE = CAPITAL_A_VALUE - (CAPITAL_Z_VALUE + 1);
    private static final int A_VALUE = 'a';
    private static final int Z_VALUE = 'z';
    private static final int DIFF_VALUE = A_VALUE - (Z_VALUE + 1);

    public static String rot13(String message) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {

            int currentChar = message.charAt(i);
            newString.append((char) convertToRot13(currentChar));
        }
        return newString.toString();
    }

    private static int convertToRot13(int currentChar) {
        if (!isLetter(currentChar)) {
            return currentChar;
        }

        int newChar = currentChar + 13;

        if (currentChar <= CAPITAL_Z_VALUE) {
            if (newChar > CAPITAL_Z_VALUE) {
                newChar += CAPITAL_DIFF_VALUE;
            }
        } else {
            if (newChar > Z_VALUE) {
                newChar += DIFF_VALUE;
            }
        }
        return newChar;
    }

    private static boolean isLetter(int currentChar) {
        return (currentChar >= CAPITAL_A_VALUE && currentChar <= CAPITAL_Z_VALUE)
                || (currentChar >= A_VALUE && currentChar <= Z_VALUE);
    }
}
