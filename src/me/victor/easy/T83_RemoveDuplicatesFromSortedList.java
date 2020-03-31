package me.victor.easy;

import java.util.List;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

public class T83_RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        var head1 = generateNodes(List.of(1, 1, 1));
        var head2 = generateNodes(List.of(1, 1, 2, 3, 3));
        System.out.println(original(head1));
        System.out.println(original(head2));
        System.out.println(original(new ListNode(1)));
    }

    private static ListNode generateNodes(List<Integer> nums) {
        var head = new ListNode(nums.get(0));
        var pre = head;
        for (int i = 1; i < nums.size(); i++) {
            pre.next = new ListNode(nums.get(i));
            pre = pre.next;
        }
        return head;
    }

    private static ListNode original(ListNode head) {
        if (head == null) return null;
        var node = new ListNode(head.val);
        node.next = find(head.next, head.val);
        return node;
    }

    private static ListNode find(ListNode node, int preVal) {
        if (node == null) return null;
        if (node.val > preVal) {
            node.next = find(node.next, node.val);
            return node;
        }
        return find(node.next, preVal);
    }

    private static ListNode official(ListNode head) {
        var current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + (next == null ? "" : "->" + next.toString());
        }
    }
}
