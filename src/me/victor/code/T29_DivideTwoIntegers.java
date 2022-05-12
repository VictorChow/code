package me.victor.code;

/**
 * https://leetcode.cn/problems/divide-two-integers/
 */
class T29_DivideTwoIntegers {

   public int divide(int dividend, int divisor) {
      int sign = 1, ans = 0;
      if (dividend == (1 << 31)) { // 边界值处理
         if (divisor == -1) return ~(1 << 31); // 溢出处理
         if (divisor > 0) dividend += divisor; // ans不溢出就降值处理
         else dividend -= divisor;
         ans = 1;
      }
      if (divisor == (1 << 31)) return ans; // 除数边界值处理
      if ((dividend | divisor) < 0 && (dividend ^ divisor) < 0) sign = -1;
      // 全改为正数做
      if (dividend < 0) dividend = -dividend;
      if (divisor < 0) divisor = -divisor;
      // 通过移位计算值, 有点类似辗转相除法,
      // 一个例子: 1024 / 3 = 3 * 2^8 + 3 * 2^6 + 3 * 2^4 + 3 * 2^2 + 3 * 2^1 + 1(省略)
      while (dividend >= divisor) {
         int m = 1, div = divisor;
         int top = 1 << 30;
         while (div < top && (div << 1) <= dividend) {
            div <<= 1; m <<= 1;
         }
         ans += m; dividend -= div;
      }
      if (sign < 0) return -ans;
      return ans;
   }

}
