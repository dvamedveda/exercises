package ru.savelev.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a 0-indexed array words consisting of distinct strings.
 * The string words[i] can be paired with the string words[j] if:
 * The string words[i] is equal to the reversed string of words[j].
 * 0 <= i < j < words.length.
 * Return the maximum number of pairs that can be formed from the array words.
 * Note that each string can belong in at most one pair.
 */
public class MaximumNumberOfStringPairs {

    public static void main(String[] args) {
        MaximumNumberOfStringPairs test = new MaximumNumberOfStringPairs();
        int result = test.maximumNumberOfStringPairs(new String[]{"cd","ac","dc","ca","zz"});
        System.out.println(result);
    }

    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> wordset = new HashSet<>(50);
        int count = 0;
        String searching;
        for (String word : words) {
            searching = new String(new char[]{word.charAt(1), word.charAt(0)});
            if (wordset.contains(searching)) {
                count++;
                wordset.remove(searching);
            } else {
                wordset.add(word);
            }
        }
        return count;
    }
}
