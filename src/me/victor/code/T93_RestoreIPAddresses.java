package me.victor.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/restore-ip-addresses/
 */
class T93_RestoreIPAddresses {

    public static void main(String[] args) {
        var t = new T93_RestoreIPAddresses();
        System.out.println(t.restoreIpAddresses("25525511135"));
        System.out.println(t.restoreIpAddresses("01000"));
    }

    public List<String> restoreIpAddresses(String s) {
        var ans = new ArrayList<String>();
        find(ans, new ArrayList<>(), s.toCharArray(), 0);
        return ans;
    }

    private void find(List<String> ans, List<Integer> list, char[] chs, int idx) {
        if (chs.length - idx < 4 - list.size()) return;
        if (idx == chs.length) {
            ans.add(list.stream().map(Objects::toString).collect(Collectors.joining(".")));
            return;
        }
        var c = chs[idx];
        if (list.size() < 4) {
            list.add(c - '0');
            find(ans, list, chs, idx + 1);
            list.remove(list.size() - 1);
        }
        if (!list.isEmpty()) {
            var lastIdx = list.size() - 1;
            var lastInt = list.get(lastIdx);
            if (lastInt == 0) return;
            var i = lastInt * 10 + (c - '0');
            if (i >= 0 && i <= 255) {
                list.set(lastIdx, i);
                find(ans, list, chs, idx + 1);
                list.set(lastIdx, lastInt);
            }
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        var ans = new ArrayList<String>();
        find(ans, new ArrayList<>(), s.toCharArray(), 0);
        return ans;
    }

    private void find2(List<String> ans, List<String> list, char[] chs, int idx) {
        if (idx == chs.length) {
            if (list.size() == 4) ans.add(String.join(".", list));
            return;
        }
        var c = chs[idx];
        if (list.size() < 4) {
            list.add(String.valueOf(c));
            find2(ans, list, chs, idx + 1);
            list.remove(list.size() - 1);
        }
        if (!list.isEmpty()) {
            var lastIdx = list.size() - 1;
            var lastStr = list.get(lastIdx);
            if (lastStr.charAt(0) == '0') return;
            var i = Integer.parseInt(lastStr + c);
            if (i >= 0 && i <= 255) {
                list.set(lastIdx, lastStr + c);
                find2(ans, list, chs, idx + 1);
                list.set(lastIdx, lastStr);
            }
        }
    }
}
