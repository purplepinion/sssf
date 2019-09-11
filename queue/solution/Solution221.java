package com.chrisz.algorithm.example.queue.solution;

import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
//221. 链表求和 II
//        中文English
//        假定用链表表示两个数，其中每个节点仅包含一个数字。
//        假设这两个数的数字顺序排列，请设计一种方法将两个数
//        相加，并将其结果表现为链表的形式。
//
//        样例
//        样例 1:
//
//        输入: 6->1->7   2->9->5
//        输出: 9->1->2
//        样例 2:
//
//        输入: 1->2->3   4->5->6
//        输出: 5->7->9

// 思路一：反转链表从各位向前相加，进位，然后再反转

// 思路二：用两个栈，将节点入栈，出栈时相加，再连接


public class Solution221 {

    public ListNode addLists2(ListNode l1, ListNode l2) {

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1!=null){
            stack1.push(p1);
            p1 = p1.next;
        }

        while (p2!=null){
            stack2.push(p2);
            p2 = p2.next;
        }

        int carry = 0;

        ListNode dummy = new ListNode(0);

        while (!stack1.empty()&&!stack2.empty()){
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            int val = node1.val + node2.val + carry;

            carry = (val>10)?1:0;

            if(carry==1){
                val%=10;
            }

            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        while (!stack1.empty()){
            ListNode node1 = stack1.pop();

            int val = node1.val + carry;

            carry = (val>10)?1:0;

            if(carry==1){
                val%=10;
            }

            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        while (!stack2.empty()){
            ListNode node2 = stack2.pop();

            int val = node2.val + carry;

            carry = (val>10)?1:0;

            if(carry==1){
                val%=10;
            }

            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        if(carry==1){
            ListNode newNode = new ListNode(1);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        return dummy.next;

    }
}
