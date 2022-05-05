package me.victor.code;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

public class T203_RemoveLinkedListElements {

    public static void main(String[] args) {

    }

    public ListNode original(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;
        else {
            ListNode pre = head, tmp = head.next;
            while (tmp != null) {
                if (tmp.val == val) {
                    pre.next = tmp.next;
                } else {
                    pre = tmp;
                }
                tmp = tmp.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
