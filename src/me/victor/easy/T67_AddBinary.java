package me.victor.easy;

import java.math.BigInteger;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */

public class T67_AddBinary {

    public static void main(String[] args) {
        System.out.println(original("11", "1")); //100
        System.out.println(original("1010", "1011")); //10101
        System.out.println(official("11", "1")); //100
        System.out.println(official("1010", "1011")); //10101
    }

    private static String original(String a, String b) {
        byte[] arr1 = a.getBytes(), arr2 = b.getBytes();
        var maxLen = Math.max(a.length(), b.length());
        if (arr1.length < maxLen) arr1 = fill(arr1, maxLen);
        if (arr2.length < maxLen) arr2 = fill(arr2, maxLen);
        var newArr = new byte[maxLen];
        for (int i = 0; i < maxLen; i++) newArr[i] = (byte) (arr1[i] + arr2[i]);
        return new String(plus(newArr, maxLen - 1, false));
    }

    /**
     * https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode/
     */
    private static String official(String a, String b) {
        var x = new BigInteger(a, 2);
        var y = new BigInteger(b, 2);
        var zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

    private static byte[] fill(byte[] arr, int maxLen) {
        var tmp = new byte[maxLen];
        System.arraycopy(arr, 0, tmp, maxLen - arr.length, arr.length);
        for (int i = 0; i < maxLen - arr.length; i++) tmp[i] = 48;
        return tmp;
    }

    private static byte[] plus(byte[] arr, int index, boolean isAdd) {
        if (index == -1) {
            if (!isAdd) return arr;
            var newArr = new byte[arr.length + 1];
            newArr[0] = '1';
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            return newArr;
        }
        if (isAdd) arr[index] = (byte) (arr[index] + 1);
        var isOver = arr[index] >= ('1' + '1');
        if (isOver) arr[index] = (byte) (arr[index] - ('1' + '1') + '0');
        else arr[index] = (byte) (arr[index] - '0');
        return plus(arr, index - 1, isOver);
    }
}
