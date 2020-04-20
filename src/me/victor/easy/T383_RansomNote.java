package me.victor.easy;

import java.util.Arrays;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class T383_RansomNote {

    public static void main(String[] args) {
        System.out.println(original("a", "b"));
        System.out.println(original("aa", "ab"));
        System.out.println(original("aa", "aab"));
        System.out.println(original("", ""));
        System.out.println(original("qwertyuiop", "sdjfkaqwryweuorywtpqoweweitet"));
    }

    private static boolean original(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (magazine.length() < ransomNote.length()) return false;
        char[] chars1 = ransomNote.toCharArray(), chars2 = magazine.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int i1 = 0, i2 = 0;
        while (i1 < chars1.length) {
            var c1 = chars1[i1];
            char c2;
            do {
                if (i2 >= chars2.length) return false;
                c2 = chars2[i2++];
            } while (c1 != c2);
            i1++;
        }
        return true;
    }
}
