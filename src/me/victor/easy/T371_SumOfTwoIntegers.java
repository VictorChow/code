package me.victor.easy;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */

public class T371_SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(original(123, 490));
        System.out.println(original(-2, 3));
        System.out.println(original(-10, 4));
    }

    private static int original(int a, int b) {
        var sum = a ^ b;
        var carry = (a & b) << 1;
        while (carry != 0) {
            var tmpSum = sum ^ carry;
            var tmpCarry = (sum & carry) << 1;
            sum = tmpSum;
            carry = tmpCarry;
        }
        return sum;
    }
}
