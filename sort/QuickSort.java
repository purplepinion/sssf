package com.chrisz.algorithm.example.sort;

//todo 不稳定
//todo 时间复杂度 O(NlogN)
//todo 空间复杂度 O(1)
//todo 额外空间 否
public class QuickSort {

//    快速排序（Quicksort）是对冒泡排序的一种改进。基本思想是：
//    通过一趟排序将要排序的数据分割成独立的两部分，
//    其中一部分的所有数据都比另外一部分的所有数据都要小，
//    然后再按此方法对这两部分数据分别进行快速排序，
//    整个排序过程可以递归进行，以此达到整个数据变成有序序列


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int test[] = {5,9,3,4,7,2,8,9,3,9};
        quickSort.sortIntegers(test);
        for (int num:test
             ) {
            System.out.println(num);
        }
    }

    public void sortIntegers(int[] A) {
        if(A==null || A.length==0){
            return;
        }

        quickSort(A,0,A.length-1);
    }

    private void quickSort(int[] a, int start, int end) {

        if(start>=end){
            return;
        }
        int left = start;
        int right = end;
        int mid = start + (end - start)/2;

        int povit = a[mid];

        while (left<=right){
            while (left<=right&&a[left]<povit){
                left++;
            }
            while (left<=right&&a[right]>povit){
                right--;
            }

            if(left<=right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }


        }

        quickSort(a,start,right);
        quickSort(a,left,end);
    }
}
