package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
class T23_MergeKSortedLists {
    public static void main(String[] args) {
        var t = new T23_MergeKSortedLists();
        var node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        var node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        var node3 = new ListNode(2);
        node3.next = new ListNode(6);

        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
        System.err.println(t.mergeKLists(new ListNode[]{node1, node2, node3}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(new ArrayList<>(Arrays.stream(lists).toList()));
    }

    private ListNode merge(List<ListNode> list) {
        list.removeIf(Objects::isNull);
        if (list.isEmpty()) return null;
        if (list.size() == 1) return list.get(0);
        var node = list.stream().min(Comparator.comparingInt(o -> o.val)).get();
        list.set(list.indexOf(node), node.next);
        node.next = merge(list);
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int x) {val = x;}

        @Override
        public String toString() {
            return val + (next == null ? "" : "->" + next);
        }
    }
}
