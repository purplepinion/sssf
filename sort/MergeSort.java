package com.chrisz.algorithm.example.sort;


//todo 稳定
//todo 时间复杂度 O(NlogN)
//todo 空间复杂度 O(1)
//todo 额外空间 是
public class MergeSort {

//    归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
//    该算法采用经典的分治（divide-and-conquer）策略
//    （分治法将问题分(divide)成一些小的问题然后递归求解，
//    而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。



    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        int len  = A.length;

        int[] temp = new int[len];

        mergeSort(A,0,len-1,temp);


    }

    private void mergeSort(int[] A,int start,int end,int[] temp){
        if(start<end){
            int mid = start + (end - start) / 2;
            mergeSort(A,start,mid,temp);
            mergeSort(A,mid+1,end,temp);
            merge(A,start,end,temp);
        }
    }

    private void merge(int[] A,int start,int end,int[] temp){
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;

        int tempIndex = start;

        while (leftIndex<=mid&&rightIndex<=end){
            temp[tempIndex++] = A[leftIndex]<A[rightIndex]?A[leftIndex++]:A[rightIndex++];
        }

        while (leftIndex<=mid){
            temp[tempIndex++] = A[leftIndex++];
        }

        while (rightIndex<=end){
            temp[tempIndex++] = A[rightIndex++];
        }

        for (int i = start; i <= end ; i++) {

            A[i] = temp[i];
        }
    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
