package com.dpavlovich.codewars.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/600c18ec9f033b0008d55eec/train/java
 */
public class TwoSumTask {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.get(target - num);
            if (index != null) {
                return new int[]{index, i};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{};
    }

    public static int[] twoSumComplexityNSquare(int[] nums, int target) {
        int absTarget = Math.abs(target);
        for (int i = 0; i < nums.length; i++) {
            int iNum = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int jNum = nums[j];
                if (i == j) {
                    continue;
                }
                if (iNum + jNum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(twoSum(new int[]{3, 2, 4}, 3))
                .boxed().toList());
    }
}
