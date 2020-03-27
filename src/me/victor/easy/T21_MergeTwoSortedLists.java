package me.victor.easy;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class T21_MergeTwoSortedLists {
    public static void main(String[] args) {
        var node1 = node1();
        var node2 = node2();
        System.out.println("node1: " + node1);
        System.out.println("node2: " + node2);
        System.out.println(original(node1, node2));
    }

    private static ListNode node1() {
        var node = new ListNode(2);
        //                node.next = new ListNode(2);
        //                node.next.next = new ListNode(4);
        //        node.next.next.next = new ListNode(5);
        //        node.next.next.next.next = new ListNode(8);
        return node;
    }

    private static ListNode node2() {
        var node = new ListNode(1);
        //        node.next = new ListNode(3);
        //        node.next.next = new ListNode(4);
        //        node.next.next.next = new ListNode(5);
        //        node.next.next.next.next = new ListNode(8);
        return node;
    }

    public static ListNode original(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            var temp = l1;
            l1 = l2;
            l2 = temp;
        }
        var head = l1;
        while (head.next != null) {
            if (l2 == null) {
                break;
            }
            var next = head.next;
            var cur2 = l2;
            if (cur2.val >= head.val && cur2.val < next.val) {
                l2 = l2.next;
                head.next = cur2;
                cur2.next = next;
                head = cur2;
            } else {
                head = next;
            }
        }
        if (l2 != null) {
            while (head.next != null) {
                head = head.next;
            }
            head.next = l2;
        }
        return l1;
    }

    public static ListNode official(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = official(l1.next, l2);
            return l1;
        } else {
            l2.next = official(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val + (next == null ? "" : "->" + next.toString());
        }
    }

}
