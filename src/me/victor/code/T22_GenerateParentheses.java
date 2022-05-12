package me.victor.code;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 */
class T22_GenerateParentheses {

    public static void main(String[] args) {
        var t = new T22_GenerateParentheses();
        System.out.println(new TreeSet<>(t.generateParenthesis(8)));
    }

    public List<String> generateParenthesis(int n) {
        //        return generate(n).stream().toList();
        var list = new ArrayList<String>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    private void dfs(List<String> list, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (left < n) {
            dfs(list, s + "(", left + 1, right, n);
        }
        if (right < left) {
            dfs(list, s + ")", left, right + 1, n);
        }
    }
}
