package com.chrisz.algorithm.example.queue;

public class ArrayQueue<T>  implements Queue<T>{
    private T[] data;

    private int front;

    private int tail;

    private static int defaultCapacity = 10;

    private int size;

    ArrayQueue(){
        data = (T[])new Object[defaultCapacity];
        this.size = 0;
        front = 0;
        tail = 0;
    }

    ArrayQueue(int maxSize){
        defaultCapacity = maxSize;
        data = (T[])new Object[defaultCapacity];
        this.size = 0;
        front = 0;
        tail = 0;
    }

    @Override
    public void offer(T t) throws Exception {
        if(isFull()){
            throw new Exception("Queue is full!");
        }

        data[(tail++)%defaultCapacity] = t;
        size++;

    }

    @Override
    public T poll() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is Empty!");
        }
        T t = data[(front++)%defaultCapacity];
        size--;
        return t;
    }

    private boolean isFull(){
        return size == defaultCapacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
