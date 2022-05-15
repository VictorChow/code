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
        System.out.println(t.findSubstring("barfoothefoobarman", Util.arr("foo", "bar")));
        System.out.println(t.findSubstring("wordgoodgoodgoodbestword", Util.arr("word", "good", "best", "word")));
        System.out.println(t.findSubstring("barfoofoobarthefoobarman", Util.arr("bar", "foo", "the")));
        System.out.println(t.findSubstring("wordgoodgoodgoodbestword", Util.arr("word", "good", "best", "good")));

    }

    public List<Integer> findSubstring(String s, String[] words) {
        var len = words[0].length();
        var wordList = List.of(words);
        if (s.length() < len * words.length) return Collections.emptyList();
        var indices = new ArrayList<Integer>();
        var keys = new ArrayList<>(List.of(words));
        for (int l = 0; l < len; l++) {
            renewKeys(keys, wordList);
            var i = l;
            while (i + len <= s.length()) {
                var str = s.substring(i, i += len);
                if (wordList.contains(str))
                    if (keys.remove(str)) {
                        if (keys.isEmpty()) {
                            indices.add(i - len * words.length);
                            renewKeys(keys, wordList);
                            i -= len * (words.length - 1);
                        }
                    } else {
                        i -= (words.length - keys.size()) * len;
                        renewKeys(keys, wordList);
                    }
                else {
                    renewKeys(keys, wordList);
                }
            }
        }
        return indices;
    }

    private void renewKeys(List<String> list, List<String> wordList) {
        list.clear();
        list.addAll(wordList);
    }
}
