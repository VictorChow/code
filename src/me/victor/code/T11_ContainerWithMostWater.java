package me.victor.code;

/**
 * https://leetcode.cn/problems/container-with-most-water/
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
