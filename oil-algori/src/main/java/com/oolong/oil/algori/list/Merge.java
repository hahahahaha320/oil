package com.oolong.oil.algori.list;

import com.oolong.oil.algori.util.Util;

public class Merge {

    private Merge() { }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        //最终结果是必须放在a上的，所以先把a内容拷贝到aux中。a的内容就可以变化了。
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid+1;
        //从low到high进行循环，以此计算每一位置应该等于多少
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }


    //采用一个统一的辅助aux数组，避免不停地分配辅助数组
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,9,7,8};
//        int[] arr = new int[]{5,2};
        sort(arr);
        Util.printArray(arr);
    }
}
