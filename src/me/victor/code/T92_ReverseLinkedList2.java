package me.victor.code;

import me.victor.code.util.ListNode;
import me.victor.code.util.Util;

import java.util.Stack;

public class T92_ReverseLinkedList2 {

    public static void main(String[] args) {
        var t = new T92_ReverseLinkedList2();
        System.out.println(t.reverseBetween(Util.nodes(1, 2, 3, 4, 5), 3, 5));
        System.out.println(t.reverseBetween2(Util.nodes(1, 2, 3, 4, 5), 3, 5));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        var n = 1;
        ListNode h = head, pre = null, tail = null, l = null, r = null;
        while (head != null) {
            if (n > right) {
                r = head;
                break;
            }
            if (n + 1 == left) l = head;
            if (n >= left) {
                if (pre == null) {
                    pre = head;
                    head = head.next;
                    pre.next = null;
                    tail = pre;
                } else {
                    var tmp = head;
                    head = head.next;
                    tmp.next = tail;
                    tail = tmp;
                }
            } else head = head.next;
            n++;
        }
        if (l != null) l.next = tail;
        if (pre != null) pre.next = r;
        return left == 1 ? tail : h;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right) return head;
        var stack = new Stack<ListNode>();
        ListNode h = left == 1 ? null : head, pre = null;
        var n = 1;
        while (head != null) {
            if (n > right) break;
            if (n + 1 == left) pre = head;
            if (n >= left) stack.push(head);
            head = head.next;
            n++;
        }
        var rightPart = stack.peek().next;
        if (h == null) {
            h = stack.peek();
        } else if (pre != null) {
            pre.next = stack.peek();
        }
        while (!stack.isEmpty()) {
            stack.pop().next = stack.isEmpty() ? rightPart : stack.peek();
        }
        return h;
    }
}
