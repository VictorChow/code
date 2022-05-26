package me.victor.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/climbing-stairs/
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

    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        var dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
