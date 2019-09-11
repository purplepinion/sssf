package com.chrisz.algorithm.example.sort;

//todo 稳定
//todo 时间复杂度 O(N^2)
//todo 空间复杂度 O(1)
//todo 额外空间 否
public class BubbleSort {

//    冒泡排序（Bubble Sorting）的基本思想是：通过对待
//    排序序列从前向后（从下标较小的元素开始）,依次比较
//    相邻元素的值，若发现逆序则交换，使值较大
//    的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
//    向上冒。
//
//    因为排序的过程中，各元素不断接近自己的位置，如果一趟比较下
//    来没有进行过交换，就说明序列有序，因此要在排序过程中设置
//    一个标志flag判断元素是否进行过交换。从而减少不必要的比较。(这里说的优化，可以在冒泡排序写好后，在进行)



    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        int len  = A.length;

        for (int i = 0; i < len; i++) {
            boolean swap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if(A[j]>A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    swap = true;
                }

            }

            if(!swap){
                break;
            }

        }
    }
}
