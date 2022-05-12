package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
class T23_MergeKSortedLists {
    public static void main(String[] args) {
        var t = new T23_MergeKSortedLists();
        var node1 = Util.nodes(1, 4, 5);
        var node2 = Util.nodes(1, 3, 4);
        var node3 = Util.nodes(2, 6);

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
}
