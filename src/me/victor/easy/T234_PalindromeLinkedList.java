package me.victor.easy;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */

public class T234_PalindromeLinkedList {

    public static void main(String[] args) {

    }

    private static boolean original(ListNode head) {
        if (head == null) return true;
        var list = new LinkedList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(list.size() - 1 - i))) return false;
        }
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
