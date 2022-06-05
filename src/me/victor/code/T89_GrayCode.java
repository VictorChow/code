package me.victor.code;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/gray-code/
 */
public class T89_GrayCode {

    /**
     * 没兴趣做这种题
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }
}
