package com.chrisz.algorithm.example.sort;


//todo 不稳定
//todo 时间复杂度 O(N^2)
//todo 空间复杂度 O(1)
//todo 额外空间 否
public class ShellSort {

//    希尔排序法介绍
//
//    希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。
//    希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，
//    也称为缩小增量排序。
//
//    希尔排序法基本思想
//
//    希尔排序是把记录按下标的一定增量分组，
//    对每组使用直接插入排序算法排序；随着增量逐渐减少，
//    每组包含的关键词越来越多，当增量减至1时，
//    整个文件恰被分成一组，算法便终止


    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        int len  = A.length;

        int gap = 1;

        while(gap<len/3){
            gap = gap * 3 + 1;
        }

        while (gap>0){

            for (int i = gap; i < len; i++) {

                int temp = A[i];
                int j = i - gap;
                while (j>=0&&A[j]>temp){
                    swap(A,j+gap,j);
                    j -= gap;
                }
                A[j + gap] = temp;
            }

            gap = gap / 3;
        }




    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
