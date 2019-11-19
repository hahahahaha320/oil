package com.oolong.oil.algori.sort;

import com.oolong.oil.algori.util.Util;

public class Quick {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    //循环不变量：从头到i 的元素都比a[lo]小，从j+1到尾的元素都比a[lo]大。
    //i从头开始，j从尾向前，遇到不满足时停下，交换i和j的值，使其满足循环不等式。
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) break;
            }
            while (v < a[--j]) {
                if (j == lo) break;
            }
            // i和j交叉相遇
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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