package Stack;

import java.util.Arrays;

class EmptyException2 extends RuntimeException{
	
	EmptyException2(){
		super("비어있습니다.");
	}
	
	EmptyException2(String msg){
		super(msg);
	}
}

public class MyStack2 <E>{

	Object[] elements = new Object[2];
	int top = -1;
	
	public boolean isEmpty() {
		//top이 -1이면 비어있음 -> true 반환
		return top==-1;
	}
	
	public boolean isFull() {
		return top == elements.length-1;
	}
	
	public void push(E e) {
		
		if(isFull()) {
			elements = Arrays.copyOf(elements, elements.length*2);
		}
		
		elements[++top] = e;
	}
	
	@SuppressWarnings("unchecked")	
	public E peek() throws EmptyException2{
		if(isEmpty())
			throw new EmptyException2("데이터가 존재하지 않습니다.");
		return (E)elements[top];
	}
	
	@SuppressWarnings("unchecked")
	public E pop() throws EmptyException2{
		
		//맨 위의 원소를 받아옴
		E e = peek();
		
		elements[top]=null;
		top--;
		
		return e;
	}
	
	public String toString() {
		if(top==-1)
			return "[]";
		if(top==0)
			return "["+elements[0]+"]";
		
		String data = "["+elements[0];
		for(int i=1; i<=top; i++) {
			data+=","+elements[i];
		}
		data+="]";
		
		return data;
	}
}
