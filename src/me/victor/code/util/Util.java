package me.victor.code.util;

import java.util.Arrays;

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

    public static void print(int[][] arr) {
        for (int[] it : arr) {
            System.out.println(Arrays.toString(it));
        }
    }
}
