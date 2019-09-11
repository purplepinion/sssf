package com.chrisz.algorithm.example.sort;

//todo 不稳定
//todo 时间复杂度 O(NlogN)
//todo 空间复杂度 O(1)
//todo 额外空间 否
public class HeapSort {

//    创建一个堆 H[0……n-1]；
//
//    把堆首（最大值）和堆尾互换；
//
//    把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
//
//    重复步骤 2，直到堆的尺寸为 1。


    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        int len  = A.length;

        int[] temp = new int[len];

        buildMaxHeap(A,len);

        /**
         * 1.将堆顶和末尾交换
         * 2.堆大小减一
         * 3.调整堆
         */
        for (int i = len-1; i > 0 ; i--) {
            swap(A,0,i);
            len--;
            heapify(A,0,len);
        }


    }

    /**
     * 构建一个大根堆
     * @param A
     * @param len
     */
    private void buildMaxHeap(int[] A,int len){
        for (int i = len/2; i >= 0 ; i--) {
            heapify(A,i,len);
        }
    }

    /**
     * 将位置i元素及以后的元素调整位置
     * @param A
     * @param i
     * @param len
     */
    private void heapify(int[] A,int i,int len){

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if(left<len&&A[left]>A[largest]){
            largest = left;
        }

        if(right<len&&A[right]>A[largest]){
            largest = right;
        }

        if(largest != i){
            swap(A,largest,i);
            heapify(A,largest,len);
        }
    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
