package me.victor.code.util;

public class Util {

    public static ListNode nodes(int... ints) {
        var node = new ListNode();
        var tmp = node;
        for (int i : ints) {
            var item = new ListNode(i);
            tmp.next = item;
            tmp = item;
        }
        return node.next;
    }
}
