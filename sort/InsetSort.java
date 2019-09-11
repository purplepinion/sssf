package com.chrisz.algorithm.example.sort;


//todo 稳定
//todo 时间复杂度 O(N^2)
//todo 空间复杂度 O(1)
//todo 额外空间 否
public class InsetSort {

//    插入排序（Insertion Sorting）的基本思想是：
//    把n个待排序的元素看成为一个有序表和一个无序表，
//    开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
//    排序过程中每次从无序表中取出第一个元素，
//    把它的排序码依次与有序表元素的排序码进行比较，
//    将它插入到有序表中的适当位置，使之成为新的有序表。

    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        int len  = A.length;

        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if(A[j]<A[j-1]){
                    swap(A,j,j-1);
                }
            }
        }

    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
