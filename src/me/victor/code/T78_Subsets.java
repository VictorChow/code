package me.victor.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/subsets/
 */
class T78_Subsets {

    public static void main(String[] args) {
        var t = new T78_Subsets();
        System.out.println(t.subsets(Util.arr(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length);
    }

    public List<List<Integer>> subsets(int[] nums, int k) {
        if (k == 0) return List.of(Collections.emptyList());
        var ans = new ArrayList<List<Integer>>();
        for (List<Integer> it : subsets(nums, k - 1)) {
            ans.add(it);
            var list = new ArrayList<>(it);
            list.add(nums[k - 1]);
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        var ans = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            find2(ans, new ArrayDeque<>(i), nums, 0, nums.length - 1, i);
        }
        return ans;
    }

    private void find2(List<List<Integer>> ans, Deque<Integer> q, int[] nums, int l, int r, int k) {
        if (q.size() == k) {
            ans.add(List.copyOf(q));
            return;
        }
        if (r - l + 1 + q.size() < k) return;
        for (int i = l; i <= r; i++) {
            q.add(nums[i]);
            find2(ans, q, nums, i + 1, r, k);
            q.removeLast();
        }
    }
}
