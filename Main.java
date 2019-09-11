package com.chrisz.algorithm.example;


import java.util.*;

public class Main {



    private int a[];

    /**
     * 只保存可能是窗口中的最大值，入队时比较后面的与新加入的大小
     * @param deque
     * @param curIndex
     */
    private void inQueue(Deque<Integer> deque, int curIndex){
        while (!deque.isEmpty()&&a[deque.peekLast()]<=a[curIndex]){
            deque.pollLast();
        }
        deque.offer(curIndex);
    }

    /**
     * 当最大值不在队列中，出队列
     * @param deque
     * @param curIndex
     */
    private void outQueue(Deque<Integer> deque,int curIndex){
        if(deque.peekFirst()==curIndex){
            deque.pollFirst();
        }
    }

    public List<Integer> maxSlidingWindow(int[] nums, int k) {

        a = nums;

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        if(nums==null || nums.length==0 || k>nums.length){
            return ans;
        }

        /**
         * 先入队k-1个
         */
        for (int i = 0; i < k-1; i++) {
            inQueue(deque,i);
        }

        /**
         * 入队i，取最大值，出队i-k+1
         */
        for (int i = k-1; i < nums.length; i++) {
            inQueue(deque,i);
            ans.add(a[deque.peekFirst()]);
            outQueue(deque,i-k+1);
        }

        return ans;
    }
}
