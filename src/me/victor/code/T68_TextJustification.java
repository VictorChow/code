package me.victor.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/text-justification/
 */
class T68_TextJustification {

    public static void main(String[] args) {
        var t = new T68_TextJustification();
        t.fullJustify(Util.arr("This", "is", "an", "example", "of", "text", "justification."), 16).forEach(System.out::println);

    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        var ans = new ArrayList<String>();
        var list = new ArrayList<String>();
        var count = 0;
        for (String word : words) {
            if (count + list.size() + word.length() > maxWidth) {
                var arr = new char[maxWidth];
                Arrays.fill(arr, '.');
                if (list.size() == 1) {
                    var i = 0;
                    for (char c : list.get(0).toCharArray()) arr[i++] = c;
                    ans.add(new String(arr));
                } else if (list.size() == 2) {
                    var i = 0;
                    for (char c : list.get(0).toCharArray()) arr[i++] = c;
                    i += maxWidth - list.get(1).length() - i;
                    for (char c : list.get(1).toCharArray()) arr[i++] = c;
                    ans.add(new String(arr));
                } else {
                    var spaceCount = maxWidth - count;
                    var spaceSlot = list.size() - 1;
                    var spaceEach = spaceCount / spaceSlot;
                    var spaceRemain = spaceCount - spaceEach * spaceSlot;
                    var i = 0;
                    for (String s : list) {
                        for (char c : s.toCharArray()) arr[i++] = c;
                        i += spaceEach;
                        if (spaceRemain-- > 0) i += 1;
                    }
                    ans.add(new String(arr));
                }
                list.clear();
                count = 0;
            }
            list.add(word);
            count += word.length();
        }
        if (!list.isEmpty()) {
            var arr = new char[maxWidth];
            Arrays.fill(arr, ' ');
            var i = 0;
            for (String s : list) {
                for (char c : s.toCharArray()) {
                    arr[i++] = c;
                }
                i++;
            }
            ans.add(new String(arr));
        }
        return ans;
    }
}
