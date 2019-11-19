package com.oolong.familiar.test;

import com.oolong.oil.algori.util.Util;

public class Insertion {

    public static void sort(int[] arr)   {
        for(int i=1;i<arr.length;i++)   {
            for(int j=i;j>0 && arr[j] < arr[j-1] ;j--)   {
                swth(arr,j,j-1);
            }
        }
    }

    private static void swth(int[] arr,int i,int j)  {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,9,7,8};
        sort(arr);
        Util.printArray(arr);
    }
}
