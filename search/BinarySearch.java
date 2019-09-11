package com.chrisz.algorithm.example.search;

public class BinarySearch {

    public int binarySearch(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return -1;
        }

        int len = nums.length;

        int left = 0;
        int right = len - 1;


        while (left + 1 < right){
            int mid = left + (right - left)/2;

            if(nums[mid]==target){
                //todo 返回第一次找到的
                right = mid;

                //todo 返回最后一次找到的
                //left = mid;
            }else if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid;
            }
        }

        if(nums[left]==target){
            return  left;
        }

        if(nums[right]==target){
            return right;
        }

        return -1;
    }
}
