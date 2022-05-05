package me.victor.code;

import java.util.LinkedList;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */

public class T9_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(original(121));
        System.out.println(original(-121));
        System.out.println(original(10));
        System.out.println(original(3));

        System.out.println(official(121));
        System.out.println(official(-121));
        System.out.println(official(10));
        System.out.println(official(0));
        System.out.println(official(3));
        System.out.println(official(2112));
    }

    private static boolean original(int x) {
        if (x < 0) {
            return false;
        }
        var list = new LinkedList<Integer>();
        while (x != 0) {
            list.push(x % 10);
            x /= 10;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean official(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        var r = 0;
        while (r < x) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        return x == r || x == r / 10;
    }
}
