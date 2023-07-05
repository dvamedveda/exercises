package ru.savelev.leetcode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        int[] result = test.plusOne(new int[]{9, 9, 2});
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        boolean smart = true;
        for (int position = digits.length - 1; position >= 0; position--) {
            int digit = digits[position];
            if (smart) {
                digit += 1;
                smart = false;
            }
            if (digit < 10) {
                result[position + 1] = digit;
            } else {
                result[position + 1] = 0;
                smart = true;
            }
            if (position == 0 && smart) {
                result[0] = 1;
            }
        }
        return result[0] != 0 ? result : Arrays.copyOfRange(result, 1, result.length);
    }
}
