package ru.savelev.leetcode;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
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
