package me.victor.code;

import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/roman-to-integer/s
 */
public class T13_Roman2Integer {

    public static void main(String[] args) {
        System.out.println(original("III")); //3
        System.out.println(original("IV")); //4
        System.out.println(original("IX")); //9
        System.out.println(original("XIII")); //13
        System.out.println(original("LVIII")); //58
        System.out.println(original("MCMXCIV")); //1994
        System.out.println("---------");
        System.out.println(better("III")); //3
        System.out.println(better("IV")); //4
        System.out.println(better("IX")); //9
        System.out.println(better("XIII")); //13
        System.out.println(better("LVIII")); //58
        System.out.println(better("MCMXCIV")); //1994
        System.out.println("---------");
        System.out.println(modified("III")); //3
        System.out.println(modified("IV")); //4
        System.out.println(modified("IX")); //9
        System.out.println(modified("XIII")); //13
        System.out.println(modified("LVIII")); //58
        System.out.println(modified("MCMXCIV")); //1994
    }

    private static int original(String s) {
        var list = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');
        var map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int r = 0, length = s.length();
        for (int i = 0; i < length; i++) {
            var it = s.charAt(i);
            if ((it == 'I' || it == 'X' || it == 'C') && (i + 1 < length)) {
                var nextC = s.charAt(i + 1);
                var diff = list.indexOf(nextC) - list.indexOf(it);
                if (diff > 0 && diff <= 2) {
                    r = r - map.get(it) + map.get(nextC);
                    i++;
                    continue;
                }
            }
            r += map.get(it);
        }
        return r;
    }

    private static int modified(String s) {
        var map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int r = 0, length = s.length();
        var preNum = map.get(s.charAt(0));
        for (int i = 1; i < length; i++) {
            var curNum = map.get(s.charAt(i));
            if (preNum < curNum) {
                r -= preNum;
            } else {
                r += preNum;
            }
            preNum = curNum;
        }
        r += preNum;
        return r;
    }

    private static int better(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
