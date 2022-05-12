package me.victor.code;

import java.util.ArrayList;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
class T25_ReverseNodesInKGroup {

    public static void main(String[] args) {
        var t = new T25_ReverseNodesInKGroup();
        System.out.println(t.reverseKGroup(Util.nodes(1, 2, 3, 4, 5), 2));
        System.out.println(t.reverseKGroup(Util.nodes(1, 2, 3, 4, 5), 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        var list = new ArrayList<ListNode>(k);
        var tmp = head;
        for (int i = 0; i < k; i++) {
            list.add(tmp);
            tmp = tmp.next;
            if (tmp == null) break;
        }
        if (list.size() < k) return head;
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = reverseKGroup(tmp, k);
        return list.get(k - 1);
    }
}
