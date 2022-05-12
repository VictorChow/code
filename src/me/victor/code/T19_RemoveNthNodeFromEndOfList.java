package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
class T19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        var t = new T19_RemoveNthNodeFromEndOfList();
        var head = Util.nodes(1, 2, 3, 4, 5);

        System.err.println(head);
        //        System.out.println(t.removeNthFromEnd(head, 1));
        //        System.out.println(t.removeNthFromEnd(head, 2));
        //        System.out.println(t.removeNthFromEnd(head, 3));
        //        System.out.println(t.removeNthFromEnd(head, 4));
        System.out.println(t.removeNthFromEnd(head, 5));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head, r = head;
        while (r.next != null) {
            if (n > 0) n--;
            else l = l.next;
            r = r.next;
        }
        if (n != 0) return head.next;
        l.next = l.next.next;
        return head;
    }

}
