package com.oolong.oil.algori.sort;

import com.oolong.oil.algori.util.Util;

public class Selection {

    //前面一段是确认的全局最小的子数组，然后从后面一段选择出最小的加入到最小的子数组中去。
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            exch(arr, i, min);
        }
    }
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,9,7,8};
        sort(arr);
        Util.printArray(arr);

    }
}
