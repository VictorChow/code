package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/group-anagrams/
 */
class T49_GroupAnagrams {

    public static void main(String[] args) {
        var t = new T49_GroupAnagrams();
        //        System.out.println(t.groupAnagrams(Util.arr("eat", "tea", "tan", "ate", "nat", "bat", "bat")));
        //        System.out.println(t.groupAnagrams(Util.arr("eat")));
        System.out.println(t.groupAnagrams(Util.arr("old", "her")));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            var key = new String(chs);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return map.values().stream().toList();
    }
}
