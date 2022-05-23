package me.victor.code;

import java.math.BigInteger;

/**
 * https://leetcode.cn/problems/add-binary/
 */
public class T67_AddBinary {

    public static void main(String[] args) {
        System.out.println(original("11", "1")); //100
        System.out.println(original("1010", "1011")); //10101
        System.out.println(official("11", "1")); //100
        System.out.println(official("1010", "1011")); //10101
        System.out.println("~~");
        var t = new T67_AddBinary();
        System.out.println(t.addBinary("11", "1")); //100
        System.out.println(t.addBinary("1010", "1011")); //10101
        System.out.println(t.addBinary("11", "1")); //100
        System.out.println(t.addBinary("1010", "1011")); //10101
    }

    private static String original(String a, String b) {
        byte[] arr1 = a.getBytes(), arr2 = b.getBytes();
        var maxLen = Math.max(a.length(), b.length());
        if (arr1.length < maxLen) arr1 = fill(arr1, maxLen);
        if (arr2.length < maxLen) arr2 = fill(arr2, maxLen);
        var newArr = new byte[maxLen];
        for (int i = 0; i < maxLen; i++) newArr[i] = (byte) (arr1[i] + arr2[i]);
        return new String(plus(newArr, maxLen - 1, false));
    }

    /**
     * https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode/
     */
    private static String official(String a, String b) {
        var x = new BigInteger(a, 2);
        var y = new BigInteger(b, 2);
        var zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

    private static byte[] fill(byte[] arr, int maxLen) {
        var tmp = new byte[maxLen];
        System.arraycopy(arr, 0, tmp, maxLen - arr.length, arr.length);
        for (int i = 0; i < maxLen - arr.length; i++) tmp[i] = 48;
        return tmp;
    }

    private static byte[] plus(byte[] arr, int index, boolean isAdd) {
        if (index == -1) {
            if (!isAdd) return arr;
            var newArr = new byte[arr.length + 1];
            newArr[0] = '1';
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            return newArr;
        }
        if (isAdd) arr[index] = (byte) (arr[index] + 1);
        var isOver = arr[index] >= ('1' + '1');
        if (isOver) arr[index] = (byte) (arr[index] - ('1' + '1') + '0');
        else arr[index] = (byte) (arr[index] - '0');
        return plus(arr, index - 1, isOver);
    }

    public String addBinary(String a, String b) {
        char[] as = a.toCharArray(), bs = b.toCharArray();
        int max = Math.max(a.length(), b.length());
        var res = new int[max];
        int ia = as.length - 1, ib = bs.length - 1, ir = res.length - 1;
        while (true) {
            int va = 0, vb = 0;
            if (ia >= 0) va = as[ia--] - '0';
            if (ib >= 0) vb = bs[ib--] - '0';
            res[ir--] = va + vb;
            if (ir < 0) break;
        }
        var in = 0;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] += in;
            in = res[i] / 2;
            res[i] %= 2;
        }
        var sb = new StringBuilder();
        if (in != 0) sb.append(in);
        for (int i : res) sb.append(i);
        return sb.toString();
    }
}
