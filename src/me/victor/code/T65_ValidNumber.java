package me.victor.code;

/**
 * https://leetcode.cn/problems/valid-number/
 */
class T65_ValidNumber {

    public static void main(String[] args) {
        var t = new T65_ValidNumber();

        System.out.println(t.isNumber("2"));
        System.out.println(t.isNumber("0089"));
        System.out.println(t.isNumber("-0.1"));
        System.out.println(t.isNumber("+3.14"));
        System.out.println(t.isNumber("4.0"));
        System.out.println(t.isNumber("-0.9"));
        System.out.println(t.isNumber("2e10"));
        System.out.println(t.isNumber("53.5e93"));
        System.out.println(t.isNumber("-123.456e789"));
        System.out.println(t.isNumber("-01"));
        System.out.println(t.isNumber("+01"));
        System.out.println(t.isNumber("-90E3"));
        System.out.println(t.isNumber("3e+7"));
        System.out.println(t.isNumber("+6e-1"));
        System.out.println("~~~");
        System.out.println(t.isNumber("abc"));
        System.out.println(t.isNumber("1a"));
        System.out.println(t.isNumber("1e"));
        System.out.println(t.isNumber("e3"));
        System.out.println(t.isNumber("99e2.5"));
        System.out.println(t.isNumber("-+3"));
        System.out.println(t.isNumber("95a54e53"));
        System.out.println(t.isNumber("--6"));
        System.out.println(t.isNumber("."));
        System.out.println(t.isNumber("e"));
        System.out.println(t.isNumber("+-"));
        System.out.println(t.isNumber("-"));
        System.out.println(t.isNumber("6+1"));
        System.out.println(t.isNumber(".8+"));
        System.out.println(t.isNumber("0-"));
        System.out.println(t.isNumber("5-e95"));
        System.out.println(t.isNumber("092e359-2"));
    }

    public boolean isNumber(String s) {
        int sign = -1, dot = -1, e = -1, num = -1;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            var ch = chs[i];
            if (Character.isDigit(ch)) {
                if ((num != -1 && sign != -1) && (num < sign) && e == -1) return false;
                num = i;
            } else if (ch == '-' || ch == '+') {
                if (sign == -1 && e == -1 && num != -1 && i > num) return false;
                if (sign != -1 || (dot != -1 && e == -1)) return false;
                if (e != -1 && num != -1 && i > num) return false;
                sign = i;
            } else if (ch == '.') {
                if (dot != -1 || e != -1) return false;
                dot = i;
            } else if (ch == 'e' || ch == 'E') {
                if (num == -1 || e != -1) return false;
                e = i;
                sign = -1;
                num = -1;
            } else return false;
        }
        if (e != -1 && !Character.isDigit(chs[chs.length - 1])) return false;
        if (e == -1 && sign > num) return false;
        return num != -1;
    }
}
