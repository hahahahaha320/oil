package com.oolong.familiar.test;

import com.oolong.oil.algori.util.Util;

public class Quick {

    public static void sort(int[] arr)   {
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int low,int high)   {
        if(low >= high) return;
        int j = partition(arr,low,high);
        sort(arr,low,j-1);
        sort(arr,j+1,high);
    }
    public static int partition(int[] arr,int low,int high)   {
        int v = arr[low];
        int i = low,j=high + 1;
        while(true) {
            while(arr[++i] < v) {
                if(i == high) break;
            }
            while(arr[--j] > v) {
                if(j == low) break;
            }
            if(i >= j) break;
            exch(arr,i,j);
        }
        exch(arr,low,j);
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
