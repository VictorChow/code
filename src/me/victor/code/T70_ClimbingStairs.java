package me.victor.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */

public class T70_ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(original(2));
        System.out.println(original(3));
        System.out.println(original(5));
        System.out.println(original(20));
        System.out.println(original(43));
        System.out.println("------------");
        System.out.println(original2(2));
        System.out.println(original2(3));
        System.out.println(original2(5));
        System.out.println(original2(20));
        System.out.println(original2(43));
        System.out.println("------------");
        System.out.println(best(2));
        System.out.println(best(3));
        System.out.println(best(5));
        System.out.println(best(20));
        System.out.println(best(43));
    }

    private static int original(int n) {
        return calculateMap(n, new HashMap<>());
    }

    private static int original2(int n) {
        var list = new ArrayList<Integer>(n);
        for (int i = 0; i <= n; i++) list.add(0);
        return calculateList(n, list);
    }

    private static int calculateMap(int n, Map<Integer, Integer> map) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        var r = calculateMap(n - 1, map) + calculateMap(n - 2, map);
        map.put(n, r);
        return r;
    }

    private static int calculateList(int n, List<Integer> list) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        if (list.get(n) != 0) {
            return list.get(n);
        }
        var r = calculateList(n - 1, list) + calculateList(n - 2, list);
        list.set(n, r);
        return r;
    }

    private static int best(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        int p1 = 1, p2 = 2;
        for (int i = 3; i < n; i++) {
            var tmp = p2;
            p2 = p1 + p2;
            p1 = tmp;
        }
        return p1 + p2;
    }
}
