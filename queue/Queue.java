package com.chrisz.algorithm.example.queue;

public interface Queue<T> {

    public void offer(T t) throws Exception;

    public T poll() throws Exception;

    public boolean isEmpty();
}
