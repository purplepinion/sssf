package com.chrisz.algorithm.example.search;

public class orderSearch {

    //顺序查找

    public int binarySearch(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return -1;
        }

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if(nums[i]==target){
                return i;
            }
        }

        return -1;
    }
}
