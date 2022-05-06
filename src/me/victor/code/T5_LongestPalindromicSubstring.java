package me.victor.code;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 */
public class T5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        var t = new T5_LongestPalindromicSubstring();
        System.out.println(t.longestPalindrome("babsad"));
        System.out.println(t.longestPalindrome("cbbd"));
        System.out.println(t.longestPalindrome("d"));
        System.out.println(t.longestPalindrome("baaajkadd"));
        System.out.println(t.longestPalindrome("ebabab"));
    }

    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int l = 0, r = 1;
        for (int i = 0; i < chs.length; i++) {
            int low = i - 1, high = i + 1;
            while (high < chs.length && chs[high] == chs[i]) {
                high++;
            }
            while (low >= 0 && high < chs.length) {
                if (chs[low] == chs[high]) {
                    low--;
                    high++;
                    continue;
                }
                break;
            }
            if (high - low - 1 > r - l) {
                l = low + 1;
                r = high;
            }
        }
        return s.substring(l, r);
    }

    public String longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (isPalindrome(chars, i, j) && (j - i > r - l)) {
                    l = i;
                    r = j;
                }
            }
            if (chars.length - i < r - l) {
                break;
            }
        }
        return s.substring(l, r + 1);
    }

    private boolean isPalindrome(char[] chars, int l, int r) {
        int mid = l + (r - l + 1) / 2;
        while (l < mid) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }

    //    private boolean isPalindrome(String str) {
    //        char[] chars = str.toCharArray();
    //        for (int i = 0; i < chars.length / 2; i++) {
    //            if (chars[i] != chars[chars.length - i - 1]) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
}
