package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
class T24_SwapNodesInPairs {

    public static void main(String[] args) {
        var t = new T24_SwapNodesInPairs();

        ListNode node = Util.nodes(1, 2, 3, 4);
        System.out.println(t.swapPairs(node));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        var next = head.next;
        if (next == null) return head;
        var next2 = next.next;
        next.next = head;
        head.next = swapPairs(next2);
        return next;
    }

}
