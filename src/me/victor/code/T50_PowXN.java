package me.victor.code;

/**
 * Created by victor on 2022/5/18. (ง •̀_•́)ง
 */

class T50_PowXN {

    public static void main(String[] args) {
        var t = new T50_PowXN();
        System.out.println(t.myPow(2, 10));
        System.out.println(t.myPow(2.1, 3));
        System.out.println(t.myPow(2, -2));
        System.out.println(t.myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        var r = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) r *= x;
            x *= x;
        }
        return n < 0 ? 1 / r : r;
    }
}
