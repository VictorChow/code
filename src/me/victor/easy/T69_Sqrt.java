package me.victor.easy;

/**
 * 实现 int sqrt(int x) 函数
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */

public class T69_Sqrt {

    public static void main(String[] args) {
        System.out.println(original(0));
        System.out.println(original(1));
        System.out.println(original(2));
        System.out.println(original(8));
        System.out.println(original(63));
        System.out.println(original(64));
        System.out.println(original(Integer.MAX_VALUE));
    }

    private static int original(int x) {
        //牛顿迭代法想不出来了, 直接硬写
        return (int) Math.sqrt(x);
    }

    /**
     * 既然官方样例里使用了Math.pow
     * 那直接返回(int) Math.pow(x, 0.5) 不就好了???
     */
    private static int official(int x) {
        if (x < 2) return x;
        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }
}
