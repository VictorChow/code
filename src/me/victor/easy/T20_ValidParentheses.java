package me.victor.easy;

import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */

public class T20_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(original("()"));
        System.out.println(original("()[]{}"));
        System.out.println(original("(]"));
        System.out.println(original("([)]"));
        System.out.println(original("{[]}"));
        System.out.println(original("(("));
    }

    private static boolean original(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        var stack = new Stack<Integer>();
        var map = Map.of('(', 1, ')', -1, '{', 2, '}', -2, '[', 3, ']', -3);
        for (int i = 0; i < s.length(); i++) {
            var num = map.get(s.charAt(i));
            if (num > 0) {
                stack.push(num);
            } else if (stack.isEmpty() || stack.pop() + num != 0) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean official(String s) {
        //官方样例思路类似
        return false;
    }
}
