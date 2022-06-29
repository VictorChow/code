package me.victor.code;

/**
 * https://leetcode.cn/problems/compare-version-numbers/
 */

class T165_CompareVersionNumbers {

    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        for (int n = 0; n < Math.max(a1.length, a2.length); n++) {
            int i = (n < a1.length ? Integer.parseInt(a1[n]) : 0);
            int j = (n < a2.length ? Integer.parseInt(a2[n]) : 0);
            if (i < j) return -1;
            else if (i > j) return 1;
        }
        return 0;
    }
}
