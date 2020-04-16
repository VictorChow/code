package me.victor.easy;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by victor on 2020/4/16. (ง •̀_•́)ง
 */

public class T290_WordPattern {

    public static void main(String[] args) {
        System.out.println(original("abba", "dog cat cat dog"));
        System.out.println(original("abba", "dog cat cat fish"));
        System.out.println(original("aaaa", "dog cat cat dog"));
        System.out.println(original("abba", "dog dog dog dog"));
        System.out.println(original("aaaa", "dog dog dog dog"));
    }

    private static boolean original(String pattern, String str) {
        var map = new HashMap<Character, String>((int) (pattern.length() / 0.75 + 1));
        var arr = pattern.toCharArray();
        var words = str.split(" ");
        if (arr.length != words.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]) && map.containsValue(words[i])) return false;
            if (map.containsKey(arr[i]) && !Objects.equals(map.get(arr[i]), words[i])) return false;
            map.put(arr[i], words[i]);
        }
        return true;
    }
}
