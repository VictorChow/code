package me.victor.code;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
class T19_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        var t = new T19_RemoveNthNodeFromEndOfList();
        var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.err.println(head);
//        System.out.println(t.removeNthFromEnd(head, 1));
//        System.out.println(t.removeNthFromEnd(head, 2));
//        System.out.println(t.removeNthFromEnd(head, 3));
//        System.out.println(t.removeNthFromEnd(head, 4));
        System.out.println(t.removeNthFromEnd(head, 5));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head, r = head;
        while (r.next != null) {
            if (n > 0) n--;
            else l = l.next;
            r = r.next;
        }
        if (n != 0) return head.next;
        l.next = l.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + " " + (next == null ? "" : next.toString());
        }
    }
}
