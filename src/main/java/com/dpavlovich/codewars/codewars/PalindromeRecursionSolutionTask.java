package com.dpavlovich.codewars.codewars;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.codewars.com/kata/600c18ec9f033b0008d55eec/train/java
 *
 * using recursion solution -> Exception: java.lang.StackOverflowError
 */
public class PalindromeRecursionSolutionTask {

    public static BigInteger findReverseNumber(long n) {
        return findPalindromeNValue(n);
    }

    private static BigInteger findPalindromeNValue(long number) {
        return findPalindromeNValue(BigInteger.ZERO, number - 1);
    }

    private static BigInteger findPalindromeNValue(BigInteger currentValue,
                                                   long currentNumberOfNumber) {
        if (isPalindrome(currentValue)) {
            if (currentNumberOfNumber == 0) {
                return currentValue;
            }
            return findPalindromeNValue(currentValue.add(BigInteger.ONE),
                    currentNumberOfNumber - 1);
        }
        return findPalindromeNValue(currentValue.add(BigInteger.ONE), currentNumberOfNumber);
    }

    private static boolean isPalindrome(BigInteger number) {
        return isPalindrome(new LinkedList<>(), number);
    }

    private static boolean isPalindrome(Queue<Integer> digits, BigInteger number) {
        int digit = number.remainder(BigInteger.TEN)
                .intValue();
        digits.add(digit);

        boolean prev = true;
        if (number.compareTo(BigInteger.TEN) >= 0) {
            prev = isPalindrome(digits, number.divide(BigInteger.TEN));
        }
        prev = prev & digits.poll() == digit;
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(findReverseNumber(1000));
    }

}
