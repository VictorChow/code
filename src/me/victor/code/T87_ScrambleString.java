package me.victor.code;

import java.util.HashMap;
import java.util.Map;

public class T87_ScrambleString {

    public static void main(String[] args) {
        var t = new T87_ScrambleString();
        System.out.println(t.isScramble("great", "rgeat"));
        System.out.println(t.isScramble("abcde", "caebd"));
        System.out.println(t.isScramble("a", "a"));
        System.out.println(t.isScramble("a", "b"));
        System.out.println(t.isScramble("ab", "ba"));
        System.out.println(t.isScramble("abcdbdacbdac", "bdacabcdbdac"));
        System.out.println(t.isScramble("abcdbdac", "bdacabcd"));

    }

    public boolean isScramble(String s1, String s2) {
        return isScramble(new HashMap<>(s1.length() * s1.length()), s1, s2);
    }

    public boolean isScramble(Map<String, Boolean> map, String s1, String s2) {
        var key = s1 + ":" + s2;
        if (map.containsKey(key)) return map.get(key);
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        var b = true;
        for (int i = 0; i < chs2.length; i++) {
            if (!s1.contains(String.valueOf(chs2[i]))) {
                map.put(key, false);
                return false;
            }
            if (chs1[i] != chs2[i]) b = false;
        }
        if (b) {
            map.put(key, true);
            return true;
        }
        for (int i = 1; i < chs1.length; i++) {
            var s1l = s1.substring(0, i);
            var s2l = s2.substring(0, i);
            var s2l2 = s2.substring(s2.length() - i);
            var s1r = s1.substring(i);
            var s2r = s2.substring(i);
            var s2r2 = s2.substring(0, s2.length() - i);
            if ((isScramble(map, s1l, s2l) && isScramble(map, s1r, s2r)) || (isScramble(map, s1l, s2l2) && isScramble(map, s1r, s2r2))) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }


}
