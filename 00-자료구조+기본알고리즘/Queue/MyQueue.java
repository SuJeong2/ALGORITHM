package Queue;

import java.util.Arrays;

class EmptyException3 extends RuntimeException {
	EmptyException3() {
		super("비어있습니다.");
	}

	EmptyException3(String msg) {
		super(msg);
	}
}
public class MyQueue <E>{

	Object[] elements = new Object[2];
	int front=-1, rear=-1;
	
	public boolean isEmpty() {
		return front==rear;
	}
	
	public boolean isFull() {
		return rear == elements.length-1;
	}
	
	public void enqueue(E e) {
		if(isFull())
			elements = Arrays.copyOf(elements, elements.length*2);
		
		elements[++rear] = e;
	}
	
	public E peek() {
		if(isEmpty())
			throw new EmptyException3("데이터가 존재하지 않습니다.");
		
		return (E) elements[front+1];
	}
	public E dequeue() {
		E e = peek();
		elements[++front]=null;
		
		return e;
	}
	
	public String toString() {
		if(front==rear)
			return "[]";
		
		if(rear - front == 1)
			return "["+elements[front+1]+"]";
		
		String data = "["+elements[front+1];
		for(int i=front+2; i<=rear; i++) {
			data+=","+elements[i];
		}
		data+="]";
		return data;
	}
}
