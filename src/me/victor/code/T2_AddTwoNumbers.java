package me.victor.code;

import me.victor.code.util.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class T2_AddTwoNumbers {

    public static void main(String[] args) {
        System.out.println(new T2_AddTwoNumbers().addTwoNumbers(new ListNode(0), new ListNode(0)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null, tmp = null;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int val = i1 + i2 + flag;
            flag = val / 10;
            val = val % 10;
            ListNode node = new ListNode(val);
            if (root == null) {
                root = node;
            } else {
                tmp.next = node;
            }
            tmp = node;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return root;
    }
}
