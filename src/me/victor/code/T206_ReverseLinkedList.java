package me.victor.code;

import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class T206_ReverseLinkedList {

    public static void main(String[] args) {
        var node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        System.out.println(node);
        //        System.out.println(iteration(node));
        System.out.println(recursion(node));
    }

    private static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) return head;
        var p = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private static ListNode iteration(ListNode head) {
        ListNode prv = null, cur = head;
        while (cur != null) {
            var next = cur.next;
            cur.next = prv;
            prv = cur;
            cur = next;
        }
        return prv;
    }

    private static ListNode original(ListNode head) {
        if (head == null) return null;
        var stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        var newHead = stack.pop();
        var tmp = newHead;
        while (!stack.isEmpty()) {
            var item = stack.pop();
            tmp.next = item;
            tmp = item;
        }
        tmp.next = null;
        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + (next == null ? "" : "->" + next.toString());
        }
    }
}
