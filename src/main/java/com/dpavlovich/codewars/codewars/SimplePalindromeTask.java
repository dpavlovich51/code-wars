package com.dpavlovich.codewars.codewars;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * https://www.codewars.com/kata/600c18ec9f033b0008d55eec/train/java
 */
public class SimplePalindromeTask {

    public static int findReverseNumber(long n) {
        return countAllPalindromes(n);
    }

    private static int countAllPalindromes(long number) {
        return countAllPalindromes(number, 1, 0);
    }

    private static int countAllPalindromes(long number, int currentValue, int count) {
        if (currentValue < number) {
            if (isPalindrome(currentValue)) count++;
            return countAllPalindromes(number, currentValue + 1, count);
        } else {
            return count;
        }
    }

    private static boolean isPalindrome(long number) {
        return isPalindrome(new LinkedList<>(), number);
    }

    private static boolean isPalindrome(Queue<Long> digits, long number) {
        long digit = number % 10;
        digits.add(digit);

        if (number >= 10) {
            isPalindrome(digits, number / 10);
        }
        return digits.poll() == digit;
    }

    public static void main(String[] args) {
        System.out.println(findReverseNumber(2));
    }

}
