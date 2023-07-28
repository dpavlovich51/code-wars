package com.dpavlovich.codewars.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.codewars.com/kata/55983863da40caa2c900004e/train/java
 */
public class NextBiggerNumberWithSameDigitsTask {

    public static long nextBiggerNumber(long n) {
        if (n < 12) return -1;

        List<Integer> digits = new ArrayList<>();

        long num = n;
        do {
            digits.add((int) (num % 10));
            num /= 10;
        } while (num > 0);

        int index = replaceDigitPlacesToGetNextBiggerNumberSort(digits);
        if (index == -1) return -1;

        List<Integer> firstPart = digits.subList(index, digits.size())
                .stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), it -> {
                            Collections.reverse(it);
                            return it;
                        }));

        return Stream.concat(
                        firstPart.stream(),
                        digits.subList(0, index).stream()
                                .sorted()
                )
                .map(Long::valueOf)
                .reduce((integer, integer2) -> integer * 10 + integer2)
                .orElse(-1L);
    }

    private static int replaceDigitPlacesToGetNextBiggerNumberSort(List<Integer> digits) {
        return replaceDigitPlacesToGetNextBiggerNumberSort(digits, 0);
    }

    private static int replaceDigitPlacesToGetNextBiggerNumberSort(List<Integer> digits, int currentIndex) {
        Integer currentValue = digits.get(currentIndex);

        if (currentIndex < digits.size() - 1) {
            if (currentValue > digits.get(currentIndex + 1)) {
                return replaceWithThePrevMinValueBiggerThanCurrent(digits, currentIndex + 1);
            }
            return replaceDigitPlacesToGetNextBiggerNumberSort(digits, currentIndex + 1);
        } else return -1;
    }

    private static int replaceWithThePrevMinValueBiggerThanCurrent(List<Integer> digits, int replacedIndex) {
        if (replacedIndex == 0) {
            return replacedIndex;
        }
        return replaceWithThePrevMinValueBiggerThanCurrent(digits,
                replacedIndex,
                replacedIndex - 1,
                replacedIndex - 1);
    }

    private static int replaceWithThePrevMinValueBiggerThanCurrent(List<Integer> digits,
                                                                   int replacedIndex,
                                                                   Integer minBigValueIndex,
                                                                   Integer currentIndex) {
        Integer replacedValue = digits.get(replacedIndex);
        Integer minBigValue = digits.get(minBigValueIndex);
        Integer currentValue = digits.get(currentIndex);

        if (minBigValue >= currentValue && minBigValue > replacedValue && currentValue > replacedValue) {
            minBigValueIndex = currentIndex;
            minBigValue = currentValue;
        }

//        go next
        if (currentIndex != 0) {
            replaceWithThePrevMinValueBiggerThanCurrent(digits,
                    replacedIndex,
                    minBigValueIndex,
                    currentIndex - 1);
        } else {
            digits.set(replacedIndex, minBigValue);
            digits.set(minBigValueIndex, replacedValue);
        }

        return replacedIndex;
    }

    public static void main(String[] args) {
//        System.out.println(nextBiggerNumber(123));
        System.out.println(nextBiggerNumber(132));
        System.out.println(nextBiggerNumber(10990));
//        System.out.println(nextBiggerNumber(12));
    }

}
