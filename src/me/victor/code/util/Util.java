package me.victor.code.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Util {

    public static ListNode nodes(int... val) {
        var node = new ListNode();
        var tmp = node;
        for (int i : val) {
            var item = new ListNode(i);
            tmp.next = item;
            tmp = item;
        }
        return node.next;
    }

    public static int[] arr(int... val) {
        return val;
    }

    public static String[] arr(String... val) {
        return val;
    }

    public static char[][] arrChar2d(String val) {
        var m = Pattern.compile("\\[.*?]").matcher(val.replaceAll("(^\\[)|(]$)", ""));
        var list = new ArrayList<List<Character>>();
        var p2 = Pattern.compile("(?<=\")\\w(?=\")");
        while (m.find()) {
            var l1 = new ArrayList<Character>();
            var m2 = p2.matcher(m.group());
            while (m2.find()) l1.add(m2.group().charAt(0));
            list.add(l1);
        }
        var arr = new char[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }

    public static int[][] arrInt2d(String val) {
        var m = Pattern.compile("\\[.*?]").matcher(val.replaceAll("(^\\[)|(]$)", ""));
        var list = new ArrayList<List<Integer>>();
        var p2 = Pattern.compile("(?<=\")\\d(?=\")");
        while (m.find()) {
            var l1 = new ArrayList<Integer>();
            var m2 = p2.matcher(m.group());
            while (m2.find()) l1.add(Integer.parseInt(m2.group()));
            list.add(l1);
        }
        var arr = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }

    public static void print(int[][] arr) {
        for (var it : arr) {
            System.out.println(Arrays.toString(it));
        }
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(char[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(char[][] arr) {
        for (var it : arr) {
            System.out.println(Arrays.toString(it));
        }
    }
}
