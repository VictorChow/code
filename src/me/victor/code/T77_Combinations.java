package me.victor.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 */
class T77_Combinations {

    public static void main(String[] args) {
        var t = new T77_Combinations();
        System.out.println(t.combine(4, 3));
    }


    public List<List<Integer>> combine(int n, int k) {
        var ans = new ArrayList<List<Integer>>();
        find(ans, new ArrayDeque<>(k), 1, n, k);
        return ans;
    }

    private void find(List<List<Integer>> ans, Deque<Integer> queue, int l, int r, int k) {
        if (queue.size() == k) {
            ans.add(List.copyOf(queue));
            return;
        }
        //后面的数的数量已经凑不满k个了
        if (r - l + 1 + queue.size() < k) return;
        for (int i = l; i <= r; i++) {
            queue.add(i);
            find(ans, queue, i + 1, r, k);
            queue.removeLast();
        }
    }

}
