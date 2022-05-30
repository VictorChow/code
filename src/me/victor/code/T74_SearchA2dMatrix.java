package me.victor.code;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix/
 */
class T74_SearchA2dMatrix {

    public static void main(String[] args) {
        var t = new T74_SearchA2dMatrix();
        //        var arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //        System.out.println(t.searchMatrix(arr, 3));
        //        var arr2 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        //        System.out.println(t.searchMatrix(arr2, 13));
        //        var arr3 = new int[][]{{1}};
        //        System.out.println(t.searchMatrix(arr3, 1));
        var arr4 = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(t.searchMatrix(arr4, 11));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;
        return searchRow(searchColumn(matrix, target), target);
    }

    private int[] searchColumn(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            var m = l + (r - l) / 2;
            if (matrix[m][0] == target) return matrix[m];
            if (matrix[m][0] > target) r = m - 1;
            else l = m;
        }
        return matrix[l];
        //        int low = -1, high = matrix.length - 1;
        //        while (low < high) {
        //            int mid = (high - low + 1) / 2 + low;
        //            if (matrix[mid][0] <= target) {
        //                low = mid;
        //            } else {
        //                high = mid - 1;
        //            }
        //        }
        //        return low;
    }

    private boolean searchRow(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            var m = l + (r - l) / 2;
            if (arr[m] == target) return true;
            if (arr[m] > target) r = m - 1;
            else l = m + 1;
        }
        return false;
    }

    private boolean find(int[] arr, int l, int r, int target) {
        if (l > r) return false;
        var m = l + (r - l) / 2;
        if (arr[m] == target) return true;
        return arr[m] < target ? find(arr, m + 1, r, target) : find(arr, l, m - 1, target);
    }
}
