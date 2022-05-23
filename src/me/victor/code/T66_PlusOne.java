package me.victor.code;

import java.util.Arrays;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/plus-one/
 */
class T66_PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(original(Util.arr(5))));
        System.out.println(Arrays.toString(original(Util.arr(1, 2, 3))));
        System.out.println(Arrays.toString(original(Util.arr(4, 3, 2, 1))));
        System.out.println(Arrays.toString(original(Util.arr(9))));
        System.out.println(Arrays.toString(original(Util.arr(1, 1, 9))));
        System.out.println(Arrays.toString(original(Util.arr(1, 9, 9))));
        System.out.println(Arrays.toString(original(Util.arr(9, 9, 9, 9))));
        System.out.println("---");
        var t = new T66_PlusOne();
        System.out.println(Arrays.toString(t.plusOne(Util.arr(5))));
        System.out.println(Arrays.toString(t.plusOne(Util.arr(1, 2, 3))));
        System.out.println(Arrays.toString(t.plusOne(Util.arr(4, 3, 2, 1))));
        System.out.println(Arrays.toString(t.plusOne(Util.arr(9))));
        System.out.println(Arrays.toString(t.plusOne(Util.arr(1, 1, 9))));
        System.out.println(Arrays.toString(t.plusOne(Util.arr(1, 9, 9))));
        System.out.println(Arrays.toString(t.plusOne(Util.arr(9, 9, 9, 9))));
    }

    private static int[] original(int[] digits) {
        return plus(digits, digits.length - 1);
    }

    private static int[] plus(int[] digits, int index) {
        if (index == -1) {
            var newArr = new int[digits.length + 1];
            newArr[0] = 1;
            //这种时候其余位一定是0, 所以不需要写下面这句
            //System.arraycopy(digits, 0, newArr, 1, digits.length);
            return newArr;
        }
        var val = digits[index] + 1;
        if (val == 10) {
            digits[index] = 0;
            return plus(digits, index - 1);
        }
        digits[index] = val;
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int in = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) digits[i]++;
            else digits[i] += in;
            in = digits[i] / 10;
            if (in == 0) return digits;
            digits[i] %= 10;
        }
        var arr = new int[digits.length + 1];
        arr[0] = in;
        return arr;
    }
}
