package me.victor.easy;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class T66_PlusOne {

    public static void main(String[] args) {
        var arr1 = new int[]{1, 2, 3};
        var arr2 = new int[]{4, 3, 2, 1};
        var arr3 = new int[0];
        var arr4 = new int[]{1, 1, 9};
        var arr5 = new int[]{1, 9, 9};
        var arr6 = new int[]{9, 9, 9, 9};
        System.out.println(Arrays.toString(original(arr1)));
        System.out.println(Arrays.toString(original(arr2)));
        System.out.println(Arrays.toString(original(arr3)));
        System.out.println(Arrays.toString(original(arr4)));
        System.out.println(Arrays.toString(original(arr5)));
        System.out.println(Arrays.toString(original(arr6)));
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
}