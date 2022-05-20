package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
class T56_MergeIntervals {

    public static void main(String[] args) {
        var t = new T56_MergeIntervals();
        var arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        var arr2 = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        var arr3 = new int[][]{{2, 3}, {4, 6}, {5, 7}, {3, 4}};
        System.out.println(Arrays.deepToString(t.merge(arr)));
        System.out.println(Arrays.deepToString(t.merge(arr2)));
        System.out.println(Arrays.deepToString(t.merge(arr3)));
        System.err.println(Arrays.deepToString(t.merge2(arr)));
        System.err.println(Arrays.deepToString(t.merge2(arr2)));
        System.err.println(Arrays.deepToString(t.merge2(arr3)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        var list = new ArrayList<int[]>();
        for (int[] arr : intervals) {
            int l = arr[0], r = arr[1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < l) {
                list.add(arr);
            } else {
                var it = list.get(list.size() - 1);
                list.set(list.size() - 1, new int[]{it[0], Math.max(it[1], r)});
            }
        }
        return list.toArray(new int[][]{});
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        var list = new ArrayList<int[]>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            var arr = intervals[i];
            int l1 = arr[0], r1 = arr[1];
            var b = true;
            for (int j = list.size() - 1; j >= 0; j--) {
                int l2 = list.get(j)[0], r2 = list.get(j)[1];
                int minL = Math.min(l1, l2);
                int maxR = Math.max(r1, r2);
                if (maxR - minL <= r1 - l1 + r2 - l2) {
                    b = false;
                    list.set(j, new int[]{minL, maxR});
                    break;
                }
            }
            if (b) list.add(arr);
        }
        return list.toArray(new int[][]{});
    }
}
