package me.victor.code;

/**
 * https://leetcode.cn/problems/multiply-strings/
 */
class T43_MultiplyStrings {
    public static void main(String[] args) {
        var t = new T43_MultiplyStrings();

        System.out.println(t.multiply("12", "11"));
        System.out.println(t.multiply("0", "1"));
        System.out.println(t.multiply("1234", "2345"));
        System.out.println(t.multiply("999", "9999"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            var int1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                var int2 = num2.charAt(j) - '0';
                arr[arr.length - 2 - (i + j)] += int1 * int2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 9) {
                arr[i + 1] += arr[i] / 10;
                arr[i] = arr[i] % 10;
            }
        }
        var sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (sb.isEmpty() && arr[i] == 0) continue;
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
