package me.victor.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.victor.code.util.Util;

/**
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 */
public class T30_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        var t = new T30_SubstringWithConcatenationOfAllWords();
        //        System.out.println(t.findSubstring("barfoothefoobarman", Util.strArray("foo", "bar")));
        //        System.out.println(t.findSubstring("wordgoodgoodgoodbestword", Util.strArray("word", "good", "best", "word")));
        //        System.out.println(t.findSubstring("barfoofoobarthefoobarman", Util.strArray("bar", "foo", "the")));
        System.out.println(t.findSubstring("wordgoodgoodgoodbestword", Util.strArray("word", "good", "best", "good")));

    }

    public List<Integer> findSubstring(String s, String[] words) {
        var len = words[0].length();
        if (s.length() < len * words.length) return Collections.emptyList();
        var indices = new ArrayList<Integer>();
        var keys = new ArrayList<>(List.of(words));
        for (int l = 0; l < len; l++) {
            renewKeys(keys, words);
            var i = l;
            while (i + len <= s.length()) {
                var str = s.substring(i, i += len);
                if (keys.remove(str)) {
                    if (keys.isEmpty()) {
                        indices.add(i - len * words.length);
                        renewKeys(keys, words);
                        i -= len * (words.length - 1);
                    }
                } else {
                    i -= (words.length - keys.size()) * len;
                    renewKeys(keys, words);
                }
            }
        }
        return indices;
    }

    private void renewKeys(List<String> list, String[] words) {
        list.clear();
        list.addAll(List.of(words));
    }
}
