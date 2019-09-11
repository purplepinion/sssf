package com.chrisz.algorithm.example.queue.solution;

 //Definition for ListNode
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }

//思路1：两个指针prev cur，在之间插入

public class Solution599 {

    public ListNode insert(ListNode node, int x) {

        //链表为空
        if(node==null){
            ListNode newNode = new ListNode(x);
            newNode.next = newNode;
            return newNode;
        }

        ListNode prev = node;
        ListNode curNode = node.next;

        //链表只有一个节点
        if(prev == curNode){
            ListNode newNode = new ListNode(x);
            curNode.next = newNode;
            newNode.next = curNode;
        }

        //不全相等
        while (curNode!=node){
             if((prev.val<=x && curNode.val>=x) ||
                     (prev.val > curNode.val && (prev.val<x || x <curNode.val))){
                 ListNode newNode = new ListNode(x);
                 prev.next = newNode;
                 newNode.next = curNode;
                 break;
             }
             prev = curNode;
             curNode = curNode.next;
        }

        //全相等
        ListNode newNode = new ListNode(x);
        prev.next = newNode;
        newNode.next = curNode;

        return prev;
    }
}


//case 1:
//        输入
//        1
//        4
//        期望答案
//        4->1