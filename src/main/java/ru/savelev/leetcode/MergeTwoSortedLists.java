package ru.savelev.leetcode;

import java.util.Arrays;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        int[] array1 = new int[]{1, 2, 4};
        int[] array2 = new int[]{1, 3, 4};
        ListNode result = test.mergeTwoLists(test.prepareList(array1), test.prepareList(array2));
        int[] printArray = new int[array1.length + array2.length];
        ListNode current = result;
        for (int i = 0; i < printArray.length; i++) {
            printArray[i] = current.val;
            current = current.next;
        }
        System.out.println(Arrays.toString(printArray));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultHead = new ListNode(0);
        ListNode current = resultHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        return resultHead.next;
    }

    ListNode prepareList(int[] values) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (Integer value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return head.next;
    }
}
