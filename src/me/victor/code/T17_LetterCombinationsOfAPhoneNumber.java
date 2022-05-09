package me.victor.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
class T17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        var t = new T17_LetterCombinationsOfAPhoneNumber();
        System.out.println(t.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        var key = new HashMap<String, List<String>>();
        key.put("2", List.of("a", "b", "c"));
        key.put("3", List.of("d", "e", "f"));
        key.put("4", List.of("g", "h", "i"));
        key.put("5", List.of("j", "k", "l"));
        key.put("6", List.of("m", "n", "o"));
        key.put("7", List.of("p", "q", "r", "s"));
        key.put("8", List.of("t", "u", "v"));
        key.put("9", List.of("w", "x", "y", "z"));
        return r(digits, key);
    }

    private List<String> r(String s, Map<String, List<String>> map) {
        if (s.isEmpty()) return Collections.emptyList();
        if (s.length() == 1) return map.get(s);
        var list = new ArrayList<String>();
        var headList = map.get(String.valueOf(s.charAt(0)));
        var subList = r(s.substring(1), map);
        for (String s1 : headList) for (String s2 : subList) list.add(s1 + s2);
        return list;
    }

}
