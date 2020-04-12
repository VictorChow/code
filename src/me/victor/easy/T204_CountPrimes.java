package me.victor.easy;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

public class T204_CountPrimes {

    public static void main(String[] args) {
        System.out.println(original(10));
    }

    private static int original(int n) {
        boolean[] b = new boolean[n];
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (b[i]) continue;
            for (int j = i + i; j < n; j += i) b[j] = true;
        }
        for (boolean c : b) count += !c ? 1 : 0;
        return n > 2 ? count - 2 : 0;
    }
}
