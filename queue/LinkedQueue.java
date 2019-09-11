package com.chrisz.algorithm.example.queue;

public class LinkedQueue<T> implements Queue<T> {

    private Node front;

    private Node tail;

    private int size;

    private class Node{
        T val;
        Node next;

        Node(T t){
            val = t;
            next = null;
        }
    }

    LinkedQueue(){
        front = null;
        tail = null;
        size = 0;
    }

    @Override
    public void offer(T t) throws Exception {
        Node node = new Node(t);

        if(node==null){
            throw new Exception("Queue is full!");
        }

        if(front==null){
            front = node;
            tail = node;
            size++;
            return;
        }

        tail.next = node;
        tail = node;
        size++;

    }

    @Override
    public T poll() throws Exception {

        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }

        Node node = front;
        front = front.next;

        if(front==null){
            tail = null;
        }
        size--;

        return node.val;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
