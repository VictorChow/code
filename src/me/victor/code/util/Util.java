package me.victor.code.util;

public class Util {

    public static ListNode nodes(int... nodes) {
        var node = new ListNode();
        var tmp = node;
        for (int i : nodes) {
            var item = new ListNode(i);
            tmp.next = item;
            tmp = item;
        }
        return node.next;
    }

    public static int[] arr(int... ints) {
        return ints;
    }

    public static String[] arr(String... strings) {
        return strings;
    }
}
