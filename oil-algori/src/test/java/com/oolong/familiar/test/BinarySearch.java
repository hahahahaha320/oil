package com.oolong.familiar.test;

public class BinarySearch {
    public static int search(int key,int[] arr)  {
        if(arr == null || arr.length == 0)    {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] > key)    {
                high = mid -1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,8,9};
        int index = search(-1,arr);
        System.out.println(index);
    }
}
