package com.github.ankurpathak.leetcode.add_two_number;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode head = null, p = null;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                p = new ListNode(sum);
                head = p;
            } else {
                p.next = new ListNode(sum);
                p = p.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                p = new ListNode(sum);
                head = p;
            } else {
                p.next = new ListNode(sum);
                p = p.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                p = new ListNode(sum);
                head = p;
            } else {
                p.next = new ListNode(sum);
                p = p.next;
            }

            l2 = l2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        String num1 = "342";
        String num2 = "465";
        ListNode l1 = convertStringToListNode(num1);
        ListNode l2 = convertStringToListNode(num2);
        Solution solution = new Solution();
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        String result = convertListNodeToString(l3);
        System.out.println(result);

    }

    public static ListNode convertStringToListNode(String text) {
        ListNode l = null;
        for (int i = 0; i < text.length(); i++) {
            l = new ListNode(Integer.valueOf(text.substring(i, i + 1)), l);
        }
        return l;
    }

    public static String convertListNodeToString(ListNode l) {
        StringBuilder result = new StringBuilder();
        while (l != null) {
            result.append(String.valueOf(l.val));
            l = l.next;
        }
        return result.reverse().toString();

    }
}
