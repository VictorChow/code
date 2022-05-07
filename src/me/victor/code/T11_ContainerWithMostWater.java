package me.victor.code;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 提示：
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
class T11_ContainerWithMostWater {

    public static void main(String[] args) {
        var t = new T11_ContainerWithMostWater();
        System.out.println(t.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(t.maxArea(new int[]{1, 10}));
        System.out.println(t.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7, 1, 1, 3, 4, 10, 3, 1, 1, 1, 1, 1, 1, 1, 7}));
    }

    private int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int lh = height[l], rh = height[r];
            var cur = Math.min(lh, rh) * (r - l);
            max = Math.max(max, cur);
            if (lh < rh) l++;
            else r--;
        }
        return max;
    }

    public int maxArea1(int[] height) {
        var max = 0;
        for (int i = 0; i < height.length; i++) {
            var next = -1;
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] < height[j] && next == -1) next = j;
                var cur = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, cur);
            }
            if (next != -1) i = next - 1;
            else break;
        }
        return max;
    }
}
