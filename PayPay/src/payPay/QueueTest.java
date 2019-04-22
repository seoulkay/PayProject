package payPay;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueTest {
	
	//Create a queue with size of 4 and objects of String
	Queue<String> a = new QueueImpl<String>(4);
	
	@Test
    public void testImmutable() {
       a.enQueue("1");
       a.enQueue("2");
       a.enQueue("3");
       assertEquals("1", a.head());
       
       //Removes the element at the beginning of the immutable queue, and returns the new queue.
       Queue<String> b = a.deQueue();
       assertEquals("2", b.head());
       //Even queue a dequeued a does not change
       assertEquals("1", a.head());
    }
	
	//Queue can not enque more than its size
	@Test(expected = IllegalArgumentException.class)
	public void testEnque(){
		a.enQueue("1");
		a.enQueue("2");
		a.enQueue("3");
		a.enQueue("4");
		a.enQueue("5");
	}
	
	//No enque therefore no element on head
	@Test(expected = NoSuchElementException.class)
    public void testHead() {
        a.head();
    }
	
	//Queue size can not be less than 0
	@Test(expected = IllegalArgumentException.class)
	public void testDequeue() {
		Queue<String> b = a.deQueue();
		Queue<String> c = b.deQueue();
		Queue<String> d = c.deQueue();
		Queue<String> e = d.deQueue();
    }
	
}
