package com.oolong.oil.algori.sort;

public class BinarySearch {
    public static int search(int key,int[] arr)    {
        if(arr == null || arr.length == 0)    {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {                 //循环结束的方法
            int mid = low + (high - low)/2;  //取中间位置的方法
            if(key < arr[mid])    {
                high = mid - 1;
            } else if(key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3};
        int index = search(3,arr);
        System.out.println(index);
    }
}
