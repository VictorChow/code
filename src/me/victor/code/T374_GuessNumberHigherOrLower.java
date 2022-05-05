package me.victor.code;

/**
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 *
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 */

public class T374_GuessNumberHigherOrLower {

    public static void main(String[] args) {
        System.out.println(original(10));
    }

    private static int original(int n) {
        int l = 1, r = n, mid, x;
        do {
            mid = l + ((r - l) >> 1);
            x = guess(mid);
            if (x < 0) r = mid - 1;
            if (x > 0) l = mid + 1;
        } while (x != 0);
        return mid;
    }

    private static int guess(int num) {
        return 6 - num;
    }
}
