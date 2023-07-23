package com.dpavlovich.codewars.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.codewars.com/kata/534e01fbbb17187c7e0000c6/train/java
 *
 * <p>
 * 00000
 * ....0
 * 000.0
 * 0...0
 * 00000
 *
 */
public class MakeASpiralTask {

    public static void main(String[] args) {
        for (int[] ints : spiralize(5)) {
            List<Integer> integers = Arrays.stream(ints)
                    .<List<Integer>>collect(ArrayList::new, List::add, List::addAll);
            System.out.println(integers);
        }
    }

    public static int[][] spiralize(int n) {

        int[][] m = new int[n][n];

        int k = n - 1;
        for (int i = 0; i < n / 2; i += 2) {
            for (int j = i; j < k - i; j++) m[i][j] = 1;
            for (int j = i; j < k - i; j++) m[j][k - i] = 1;
            for (int j = i; j < k - i; j++) m[k - i][k - j] = 1;
            for (int j = i; j < k - i - 1; j++) m[k - j][i] = 1;
            if(i + 2 <= k/2) {
                m[i + 2][i + 1] = 1;
                m[i + 2][i + 2] = 1;
            }
        }

        return m;
    }
}
