package com.oolong.familiar.test;

import com.oolong.oil.algori.util.Util;

public class Selection {

    public static void sort(int[] arr)   {
        for(int i=0;i<arr.length;i++)   {
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++)   {
                if(arr[j] < arr[minIndex])    {
                    minIndex = j;
                }
            }
            swth(arr,i,minIndex);
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
