package me.victor.code;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */

public class T349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        var nums1 = new int[]{4,9,5};
//        var nums1 = new int[]{1, 2, 2, 1};
//        var nums2 = new int[]{2, 2};
        var nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(original(nums1, nums2)));
    }

    private static int[] original(int[] nums1, int[] nums2) {
        var list = Arrays.stream(nums1).distinct().boxed().collect(Collectors.toList());
        var list2 = Arrays.stream(nums2).distinct().boxed().collect(Collectors.toList());
        list.retainAll(list2);
        return list.stream().mapToInt(it -> it).toArray();
    }
}
