package me.victor.code;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

public class T42_TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(original(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(original(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 0, 1, 2, 1}));
        System.out.println(original(new int[]{3, 0, 2}));
        System.out.println(original(new int[]{5, 4, 1, 2}));
    }

    private static int original(int[] height) {
        if (height.length < 3) return 0;
        var sum = 0;
        for (var i = 0; i < height.length; ) {
            var tmp = -1;
            for (var j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    tmp = j;
                    break;
                }
            }
            if (tmp == -1) {
                if (i + 1 >= height.length) break;
                var maxIndex = maxIndex(height, i + 1);
                var std = height[maxIndex];
                for (var n = i; n < maxIndex; n++) {
                    sum += Math.max(std - height[n], 0);
                }
                i = maxIndex;
                continue;
            }
            var std = Math.min(height[i], height[tmp]);
            for (var n = i; n < tmp; n++) {
                sum += Math.max(std - height[n], 0);
            }
            i = tmp;
        }
        return sum;
    }

    private static int maxIndex(int[] height, int l) {
        var index = l;
        for (int i = l + 1; i < height.length; i++) {
            if (height[i] >= height[index]) {
                index = i;
            }
        }
        return index;
    }
}
