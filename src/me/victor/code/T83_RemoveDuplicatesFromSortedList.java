package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

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
        var t = new T83_RemoveDuplicatesFromSortedList();
        System.out.println(t.deleteDuplicates(Util.nodes(1, 1, 1)));
        System.out.println(t.deleteDuplicates(Util.nodes(1, 1, 2, 3, 3)));
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

    public ListNode deleteDuplicates(ListNode head) {
        var tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
