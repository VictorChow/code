package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */

public class T21_MergeTwoSortedLists {
    public static void main(String[] args) {
        var t = new T21_MergeTwoSortedLists();
        var node1 = Util.nodes(2, 2, 4, 5, 8);
        var node2 = Util.nodes(1, 3, 4, 5, 8);
        System.out.println(t.mergeTwoLists(node1, node2));
    }

    public static ListNode original(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            var temp = l1;
            l1 = l2;
            l2 = temp;
        }
        var head = l1;
        while (head.next != null) {
            if (l2 == null) {
                break;
            }
            var next = head.next;
            var cur2 = l2;
            if (cur2.val >= head.val && cur2.val < next.val) {
                l2 = l2.next;
                head.next = cur2;
                cur2.next = next;
                head = cur2;
            } else {
                head = next;
            }
        }
        if (l2 != null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next = l2;
        }
        return l1;
    }

    public static ListNode official(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = official(l1.next, l2);
            return l1;
        } else {
            l2.next = official(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
