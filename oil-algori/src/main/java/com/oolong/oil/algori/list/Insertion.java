package com.oolong.oil.algori.list;

import com.oolong.oil.algori.util.Util;

public class Insertion {

    //前面一段是排好序的，但不是全局最小的。然后把后面的一步步往前挪到合适的位置。
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                exch(arr, j, j-1);
            }
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
