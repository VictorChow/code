package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

public class T86_PartitionList {

    public static void main(String[] args) {
        var t = new T86_PartitionList();
        System.out.println(t.partition(Util.nodes(1, 4, 3, 2, 5, 2), 3));
        System.out.println(t.partition(Util.nodes(2, 1), 2));
        System.out.println(t.partition(Util.nodes(2, 1), 10));
        System.out.println(t.partition(Util.nodes(2, 1), 0));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lh = new ListNode(), rh = new ListNode();
        ListNode lt = lh, rt = rh;
        while (head != null) {
            if (head.val < x) {
                lt.next = head;
                head = head.next;
                lt = lt.next;
                lt.next = null;
            } else {
                rt.next = head;
                head = head.next;
                rt = rt.next;
                rt.next = null;
            }
        }
        lt.next = rh.next;
        return lh.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode lh = null, lt = null, rh = null, rt = null;
        while (head != null) {
            var val = head.val;
            if (val < x) {
                if (lh == null) {
                    lh = new ListNode(val);
                    lt = lh;
                } else {
                    lt.next = new ListNode(val);
                    lt = lt.next;
                }
            } else {
                if (rh == null) {
                    rh = new ListNode(val);
                    rt = rh;
                } else {
                    rt.next = new ListNode(val);
                    rt = rt.next;
                }
            }
            head = head.next;
        }
        if (lt != null) lt.next = rh;
        return lh == null ? rh : lh;
    }
}
