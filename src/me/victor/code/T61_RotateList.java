package me.victor.code;

import java.util.ArrayList;
import java.util.HashMap;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/rotate-list/
 */
class T61_RotateList {

    public static void main(String[] args) {
        var t = new T61_RotateList();
        System.out.println(t.rotateRight(Util.nodes(1, 2, 3, 4, 5), 2));
        System.out.println(t.rotateRight(Util.nodes(0, 1, 2), 4));
        System.out.println(t.rotateRight(Util.nodes(0, 1, 2), 30000000));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        var list = new ArrayList<ListNode>();
        var tmp = head;
        list.add(tmp);
        while (tmp.next != null) {
            tmp = tmp.next;
            list.add(tmp);
        }
        var size = list.size();
        if (size == 1) return list.get(0);
        list.get(size - 1).next = list.get(0);
        k = (size - k % size) % size;
        list.get((k - 1 + size) % size).next = null;
        return list.get(k);
    }


    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) return head;
        var preMap = new HashMap<ListNode, ListNode>();
        var tmp = head;
        var count = 1;
        while (tmp.next != null) {
            preMap.put(tmp.next, tmp);
            tmp = tmp.next;
            count++;
        }
        tmp.next = head;
        preMap.put(head, tmp);
        k = k % count;
        ListNode node = head;
        for (int i = 0; i < k; i++) node = preMap.get(node);
        preMap.get(node).next = null;
        return node;
    }
}
