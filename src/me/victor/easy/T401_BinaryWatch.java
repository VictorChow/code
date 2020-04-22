package me.victor.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * https://upload.wikimedia.org/wikipedia/commons/8/8b/Binary_clock_samui_moon.jpg
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 案例:
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * 注意事项:
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 */

public class T401_BinaryWatch {

    public static void main(String[] args) {
        System.out.println(original(2));

        System.out.println("-------------");
        var list1 = new ArrayList<>(List.of("0:48", "0:40", "0:36", "0:34", "0:33", "0:24", "0:20", "0:18", "0:17", "0:12", "0:10", "0:09", "0:06", "0:05", "0:03", "8:32", "8:16", "8:08", "8:04", "8:02", "8:01", "4:32", "4:16", "4:08", "4:04", "4:02", "4:01", "2:32", "2:16", "2:08", "2:04", "2:02", "2:01", "1:32", "1:16", "1:08", "1:04", "1:02", "1:01", "12:00", "10:00", "9:00", "6:00", "5:00", "3:00"));
        var list2 = new ArrayList<>(List.of("0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18", "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01", "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04", "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08", "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08", "8:16", "8:32", "9:00", "10:00"));
        list1.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());
        System.out.println(list1);
        System.out.println(list2);
    }


    private static List<String> original(int num) {
        if (num > 10) return null;
        var list = new ArrayList<String>();
        int hourMaxBits = 4, minuteMaxBits = 6, tmp = 0;
        while (tmp <= hourMaxBits && (num - tmp) >= 0) {
            if (num - tmp > minuteMaxBits) {
                tmp++;
                continue;
            }
            var hours = hour(tmp);
            var minutes = minute(num - tmp);
            //            System.out.println("------");
            //            System.out.println(hours);
            //            System.out.println(minutes);
            for (var hour : hours) {
                for (var minute : minutes) {
                    list.add(String.format("%d:%02d", hour, minute));
                }
            }
            tmp++;
        }
        return list;
    }

    private static void find(List<Integer> list, int[] value, int index, int maxChanged, int curChanged, int maxValue) {
        if (curChanged == maxChanged) {
            var n = intArray2Int(value);
            if (n <= maxValue) list.add(n);
            return;
        }
        for (int i = index; i < value.length; i++) {
            value[i] = 1;
            find(list, value, i + 1, maxChanged, curChanged + 1, maxValue);
            value[i] = 0;
        }
    }

    private static int intArray2Int(int[] arr) {
        var n = 0;
        for (int value : arr) {
            n <<= 1;
            n |= value;
        }
        return n;
    }

    private static List<Integer> hour(int num) {
        var list = new ArrayList<Integer>();
        if (num == 0) return List.of(0);
        var bits = new int[4];
        find(list, bits, 0, num, 0, 11);
        return list;
    }

    private static List<Integer> minute(int num) {
        var list = new ArrayList<Integer>();
        if (num == 0) return List.of(0);
        var bits = new int[6];
        find(list, bits, 0, num, 0, 59);
        return list;
    }
}
