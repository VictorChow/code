package me.victor.code;

import java.util.Objects;

/**
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 示例 1：
 * 输入：
 * ['a','a','b','b','c','c','c']
 * 输出：
 * 返回6，输入数组的前6个字符应该是：['a','2','b','2','c','3']
 * 说明：
 * 'aa'被'a2'替代。'bb'被'b2'替代。'ccc'被'c3'替代。
 *
 * 示例 2：
 * 输入：
 * ['a']
 * 输出：
 * 返回1，输入数组的前1个字符应该是：['a']
 * 说明：
 * 没有任何字符串被替代。
 *
 * 示例 3：
 * 输入：
 * ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 * 输出：
 * 返回4，输入数组的前4个字符应该是：['a','b','1','2']。
 * 说明：
 * 由于字符'a'不重复，所以不会被压缩。'bbbbbbbbbbbb'被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 注意：
 *
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 */

public class T443_StringCompression {

    public static void main(String[] args) {
        System.out.println(original(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(original(new char[]{'a'}));
        System.out.println(original(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

    //    private static int original(char[] chars) {
    //        if (chars == null || chars.length == 0) return 0;
    //        var preChar = chars[0];
    //        var count = 1;
    //        var sb = new StringBuilder();
    //        for (int i = 1; i < chars.length; i++) {
    //            if (chars[i] == preChar) count++;
    //            else {
    //                append(preChar, count, sb);
    //                preChar = chars[i];
    //                count = 1;
    //            }
    //        }
    //        append(preChar, count, sb);
    //        return sb.length();
    //    }

    private static int original(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        Character preChar = null;
        int count = 0, index = 0;
        for (char c : chars) {
            if (Objects.equals(preChar, c)) count++;
            else {
                if (preChar == null) {
                    preChar = c;
                    count = 1;
                    continue;
                }
                index = append(chars, preChar, count, index);
                preChar = c;
                count = 1;
            }
        }
        return append(chars, preChar, count, index);
    }

    private static int append(char[] chars, Character preChar, int count, int index) {
        chars[index++] = preChar;
        if (count == 1) return index;
        var countStr = String.valueOf(count);
        for (int j = 0; j < countStr.length(); j++) {
            chars[index++] = countStr.charAt(j);
        }
        return index;
    }

    //    private static void append(char preChar, int count, StringBuilder sb) {
    //        sb.append(preChar);
    //        if (count > 1) sb.append(count);
    //    }
}
