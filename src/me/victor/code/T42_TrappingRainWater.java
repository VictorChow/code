package me.victor.code;

import java.util.Arrays;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 */

public class T42_TrappingRainWater {

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


    public static void main(String[] args) {
        System.out.println(original(Util.arr(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(original(Util.arr(0, 1, 0, 2, 1, 0, 1, 3, 0, 1, 2, 1)));
        System.out.println(original(Util.arr(3, 0, 2)));
        System.out.println(original(Util.arr(5, 4, 1, 2)));

        var t = new T42_TrappingRainWater();
        System.out.println(t.trap(Util.arr(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
        System.out.println(t.trap(Util.arr(0, 1, 0, 2, 1, 0, 1, 3, 0, 1, 2, 1)));
        System.out.println(t.trap(Util.arr(3, 0, 2)));
        System.out.println(t.trap(Util.arr(5, 4, 1, 2)));
    }

    public int trap(int[] height) {
        var maxLeft = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        var maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        var sum = 0;
        for (int i = 0; i < height.length; i++) {
            var v = height[i];
            var lMax = maxLeft[i];
            var rMax = maxRight[i];
            var low = Math.min(lMax, rMax);
            if (low > v) sum += low - v;
        }
        return sum;
    }

    public int trap3(int[] height) {
        var sum = 0;
        for (int i = 0; i < height.length; i++) {
            var v = height[i];
            var lMax = getMax(height, 0, i - 1);
            var rMax = getMax(height, i + 1, height.length - 1);
            var low = Math.min(lMax, rMax);
            if (low > v) sum += low - v;
        }
        return sum;
    }

    private int getMax(int[] height, int l, int r) {
        if (l > r) return Integer.MIN_VALUE;
        var max = height[l];
        for (int i = l + 1; i <= r; i++) {
            if (height[i] > max) max = height[i];
        }
        return max;
    }

    public int trap2(int[] height) {
        int sum = 0, max = Arrays.stream(height).max().getAsInt();
        for (int i = 1; i <= max; i++) {
            int tmp = 0;
            var b = false;
            for (int k : height) {
                if (k < i) {
                    if (b) tmp++;
                } else {
                    if (!b) b = true;
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }
            }
        }
        return sum;
    }
}
