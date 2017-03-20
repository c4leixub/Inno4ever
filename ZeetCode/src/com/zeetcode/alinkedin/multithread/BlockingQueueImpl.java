package com.zeetcode.alinkedin.multithread;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueImpl<T> implements BlockingQueue<T> {

	private Queue<T> queue;
    private int capacity = 10;
     
    // Constructor 
    public BlockingQueueImpl(int capacity) {
        queue = new LinkedList<T>();
        this.capacity = capacity;
    }
     
    // Add the given element to the end of the queue, 
    // Waiting if necessary for space to become available
    public synchronized void put(T obj) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
         
        queue.add(obj);
        notifyAll();
    }
     
    // Retrive and remove the head of the queue, 
    // waiting if no elements are present
    public synchronized T take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
         
        T obj = queue.poll();
        notifyAll();
         
        return obj;
    }

}
