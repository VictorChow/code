package me.victor.code;

import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 */

public class T20_ValidParentheses {

    public static void main(String[] args) {
        var t = new T20_ValidParentheses();
        System.out.println(original("()"));
        System.out.println(t.isValid("()"));
        System.out.println(original("()[]{}"));
        System.out.println(t.isValid("()[]{}"));
        System.out.println(original("{[]}"));
        System.out.println(t.isValid("{[]}"));
        System.out.println(original("(]"));
        System.out.println(t.isValid("(]"));
        System.out.println(original("([)]"));
        System.out.println(t.isValid("([)]"));
        System.out.println(original("(("));
        System.out.println(t.isValid("(("));
        System.out.println(original(""));
        System.out.println(t.isValid(""));
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

    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;
        var stack = new Stack<Character>();
        var chs = s.toCharArray();
        var map = Map.of(')', '(', ']', '[', '}', '{');
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) return false;
            } else {
                stack.add(ch);
            }
        }
        return stack.isEmpty();
    }
}
