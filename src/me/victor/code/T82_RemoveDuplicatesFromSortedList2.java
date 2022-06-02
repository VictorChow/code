package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
class T82_RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        var t = new T82_RemoveDuplicatesFromSortedList2();
//        System.out.println(t.deleteDuplicates(Util.nodes(1, 2, 3, 3, 4, 4, 5)));
//        System.out.println(t.deleteDuplicates(Util.nodes(1, 2, 3, 3, 4, 4, 5, 5)));
//        System.out.println(t.deleteDuplicates(Util.nodes(1, 1, 1, 2, 3)));
//        System.out.println(t.deleteDuplicates(Util.nodes(1)));
//        System.out.println(t.deleteDuplicates(Util.nodes()));
        System.out.println(t.deleteDuplicates(Util.nodes(1, 1, 2)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = null, tail = null;
        for (ListNode tmp = head, dump = null; tmp != null; tmp = tmp.next) {
            if (dump != null && dump.val == tmp.val) {
                continue;
            }
            if (tmp.next != null) {
                if (tmp.val != tmp.next.val) {
                    if (h == null) {
                        h = new ListNode(tmp.val);
                        tail = h;
                    } else {
                        tail.next = new ListNode(tmp.val);
                        tail = tail.next;
                    }
                }
            } else {
                if (h == null) h = new ListNode(tmp.val);
                else tail.next = new ListNode(tmp.val);
            }
            dump = tmp;
        }
        return h;
    }
}
