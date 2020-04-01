package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */

public class T119_PascalTriangle2 {

    public static void main(String[] args) {
        System.out.println(original(0));
        System.out.println(original(1));
        System.out.println(original(2));
        System.out.println(original(20));
    }

    private static List<Integer> original(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        var all = new ArrayList<List<Integer>>();
        all.add(List.of(1));
        for (int i = 1; i <= rowIndex; i++) {
            var list = new ArrayList<Integer>();
            var preList = all.get(i - 1);
            list.add(1);
            for (int j = 1; j < preList.size(); j++) {
                list.add(preList.get(j) + preList.get(j - 1));
            }
            list.add(1);
            all.add(list);
        }
        return all.get(rowIndex);
    }

}
