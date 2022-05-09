package me.victor.code;

import java.util.LinkedHashMap;

/**
 * https://leetcode.cn/problems/integer-to-roman/
 */
public class T12_IntegerToRoman {

    public static void main(String[] args) {
        var t = new T12_IntegerToRoman();
        System.out.println(t.intToRoman(1994));
    }

    public String intToRoman(int num) {
        var map = new LinkedHashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        var sb = new StringBuilder();
        while (num != 0) {
            for (var e : map.entrySet()) {
                while (num >= e.getKey()) {
                    num -= e.getKey();
                    sb.append(e.getValue());
                }
            }
        }
        return sb.toString();
    }
}
