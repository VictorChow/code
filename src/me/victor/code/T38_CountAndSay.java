package me.victor.code;

/**
 * https://leetcode.cn/problems/count-and-say/
 */

public class T38_CountAndSay {

    public static void main(String[] args) {
        System.out.println(original(1));
        System.out.println(original(2));
        System.out.println(original(3));
        System.out.println(original(4));
        System.out.println(original(5));
        System.out.println(original(6));

        var t = new T38_CountAndSay();
        System.out.println(t.countAndSay(1));
        System.out.println(t.countAndSay(2));
        System.out.println(t.countAndSay(3));
        System.out.println(t.countAndSay(4));
        System.out.println(t.countAndSay(5));
        System.out.println(t.countAndSay(6));
    }

    private static String original(int n) {
        if (n == 1) return "1";
        var sb = new StringBuilder();
        var s = original(n - 1);
        var ch = s.charAt(0);
        var num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                num++;
            } else {
                sb.append(num).append(ch);
                ch = s.charAt(i);
                num = 1;
            }
        }
        sb.append(num).append(ch);
        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        var str = countAndSay(n - 1);
        var sb = new StringBuilder();
        var count = 1;
        var preCh = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == preCh) count++;
            else {
                sb.append(count).append(preCh);
                count = 1;
                preCh = str.charAt(i);
            }
        }
        sb.append(count).append(preCh);
        return sb.toString();
    }
}
