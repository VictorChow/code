package me.victor.code.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {val = x;}

    @Override
    public String toString() {
        return val + (next == null ? "" : "->" + next);
    }
}
