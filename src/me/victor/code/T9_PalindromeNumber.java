package me.victor.code;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/palindrome-number/
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
