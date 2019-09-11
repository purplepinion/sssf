package com.chrisz.algorithm.example.sort;

//todo 不稳定
//todo 时间复杂度 O(N^2)
//todo 空间复杂度 O(1)
//todo 额外空间 否
public class SelectionSort {

//    选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：
//    第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
//    第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
//    第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
//    第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
//    第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
//    总共通过n-1次，得到一个按排序码从小到大排列的有序序列。


    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        int len  = A.length;

        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if(A[j]<A[minIndex]){
                    minIndex = j;
                }
            }

            swap(A,minIndex,i);
        }
    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
