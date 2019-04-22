package payPay;

import java.util.NoSuchElementException;

public final class QueueImpl<T> implements Queue<T>{
	
	private T[] queue;
	private int size = 0;
	private int rear = -1;

	public QueueImpl(int size) {
		if(size <= 0){
			throw new IllegalArgumentException("The queue size should be bigger than 0.");
		}
		this.size = size;
		T[] data = (T[]) new Object[size];
		queue = data;	
	}
	
	//This constructor only used when dequeue() called
	private QueueImpl(int size, int rear, T[] queue){
		if(size <= 0){
			throw new IllegalArgumentException("The queue size should be bigger than 0.");
		}
		this.size = size;
		this.rear = rear;
		T[] data = (T[]) new Object[size];
		//Move current values to new queue until rear
		for(int i = 0 ; i < rear ; i++){
			data[i] = queue[i+1];
		}
		this.queue = data;          
	}

	@Override
	public Queue<T> enQueue(T e) {
		if(size == rear+1){
			throw new IllegalArgumentException("Queue is full.");
		}
		queue[++rear] = e;
		return this;
	}

	@Override
	public Queue<T> deQueue() {
		//Create new queue with 1 less size of current value and contains rear value
		Queue<T> result = new QueueImpl(size-1, rear, queue);
		return result;
	}

	@Override
	public T head() {
		if(isEmpty() || queue[0] == null){
			throw new NoSuchElementException("The queue is empty.");
		}
		return queue[0];
	}

	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}
	
}
