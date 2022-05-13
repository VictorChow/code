package me.victor.code;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
class T32_LongestValidParentheses {

    public static void main(String[] args) {
        var t = new T32_LongestValidParentheses();
        System.out.println(t.longestValidParentheses("(()"));
        System.out.println(t.longestValidParentheses2("(()"));
        System.out.println(t.longestValidParentheses(")()())"));
        System.out.println(t.longestValidParentheses2(")()())"));
        System.out.println(t.longestValidParentheses(")))"));
        System.out.println(t.longestValidParentheses2(")))"));
        System.out.println(t.longestValidParentheses("(())()()()()((((()()()()((()()()())))(()()(())))()()))))()()()"));
        System.out.println(t.longestValidParentheses2("(())()()()()((((()()()()((()()()())))(()()(())))()()))))()()()"));
    }

    public int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;
        var res = 0;
        var dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        var dp = new int[s.length() + 1];
        var chs = s.toCharArray();
        for (int i = 2; i <= chs.length; i++) {
            if (chs[i - 1] == '(') {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], lastLength(chs, i - 1));
            }
        }
        return dp[s.length()];
    }

    private int lastLength(char[] chs, int r) {
        int len = 0, count = 0;
        for (int i = r; i >= 0; i--) {
            var ch = chs[i];
            if (ch == ')') count++;
            else {
                count--;
                if (count < 0) return r - i;
                if (count == 0 && r - i + 1 > len) len = r - i + 1;
            }
        }
        return len;
    }
}
