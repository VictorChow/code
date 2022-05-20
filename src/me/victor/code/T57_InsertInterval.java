package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/insert-interval/
 */
class T57_InsertInterval {

    public static void main(String[] args) {
        var t = new T57_InsertInterval();

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.stream(intervals).toList());
        list.add(newInterval);
        list.sort(Comparator.comparingInt(o -> o[0]));
        var ans = new ArrayList<int[]>();
        for (int[] it : list) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < it[0]) ans.add(it);
            else
                ans.set(ans.size() - 1, new int[]{ans.get(ans.size() - 1)[0], Math.max(it[1], ans.get(ans.size() - 1)[1])});
        }
        return ans.toArray(new int[][]{});
    }
}
