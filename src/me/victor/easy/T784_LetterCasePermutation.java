package me.victor.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 *
 * 注意：
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */

public class T784_LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(original("A1D"));
    }

    private static List<String> original(String S) {
        var list = new ArrayList<String>();
        handle(S.toCharArray(), 0, list);
        return list;
    }

    private static void handle(char[] arr, int index, List<String> list) {
        System.out.println("111");
        if (index >= arr.length) {
            var str = String.valueOf(arr);
            if (!list.contains(str)) {
                list.add(str);
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            var isDigit = arr[i] >= '0' && arr[i] <= '9';
            if (!isDigit) {
                arr[i] ^= ' ';
            }
            handle(arr, index + 1, list);
            if (!isDigit) {
                arr[i] ^= ' ';
            }
        }
    }
}
