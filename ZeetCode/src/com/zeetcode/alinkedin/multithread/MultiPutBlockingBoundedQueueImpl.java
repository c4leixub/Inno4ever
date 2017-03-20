package com.zeetcode.alinkedin.multithread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiPutBlockingBoundedQueueImpl<E> implements
		MultiPutBlockingBoundedQueue<E> {

	private Queue<E> queue;
	private int capacity;

	@Override
	public void init(int capacity) throws Exception {
		if (isInitialized()) { // already initialized
            throw new IllegalStateException();
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        
		queue = new LinkedList<E>();
		this.capacity = capacity;
	}

	@Override
	public synchronized E get() throws Exception {
		if (!isInitialized()) {
            throw new IllegalStateException();
        }
		
		while (queue.size() == 0) {
            wait();
        }
         
        E obj = queue.poll();
        notifyAll();
         
        return obj;
	}

	@Override
	public void put(E obj) throws Exception {
		List<E> objs = new ArrayList<E>();
		objs.add(obj);
		multiput(objs);
	}

	@Override
	public synchronized void multiput(List<E> objs) throws Exception {
		if (!isInitialized()) {
            throw new IllegalStateException();
        }
		
		while (capacity-queue.size() < objs.size()) {
            wait();
        }
         
        queue.addAll(objs);
        notifyAll();
	}
	
	private boolean isInitialized() {
		return queue != null;
	}

}
