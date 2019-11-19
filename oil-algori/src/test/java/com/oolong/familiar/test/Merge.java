package com.oolong.familiar.test;

import com.oolong.oil.algori.util.Util;

public class Merge {
    public static void sort(int[] arr)  {
        int[] aux = new int[arr.length];
        sort(arr,aux,0,arr.length - 1);

    }
    public static void sort(int[] arr,int[] aux,int low,int high)   {
//        if (high <= low) return;
        int mid = low + (high-low)/2;
        if(low < high) {
            sort(arr, aux, low, mid);
            sort(arr, aux, mid + 1, high);
            merge(arr, aux, low, mid, high);
        }
    }

    public static void merge(int[] arr,int[] aux,int low,int mid,int high)  {
        for(int k = low;k <= high;k++)   {
            aux[k] = arr[k];
        }
        int i = low,j = mid+1;
        for(int k = low;k <= high;k++)   {
             if(i > mid)                arr[k] = aux[j++];
             else if(j > high)          arr[k] = aux[i++];
             else if(aux[i] < aux[j])   arr[k] = aux[i++];
             else                       arr[k] = aux[j++];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,9,7,8};
//        int[] arr = new int[]{5,2};
        sort(arr);
        Util.printArray(arr);
    }
}
