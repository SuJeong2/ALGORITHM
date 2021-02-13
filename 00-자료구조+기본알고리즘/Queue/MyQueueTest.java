package Queue;

import java.util.Scanner;

public class MyQueueTest {

	Scanner sc = new Scanner(System.in);
	MyQueue<String> queue = new MyQueue<>();
	
	public int menu() {
		System.out.println("메뉴 선택");
		System.out.println("-----------------------");
		System.out.println("1. 입력");
		System.out.println("2. 꺼내기(삭제)");
		System.out.println("3. 꺼내기(유지)");
		System.out.println("4. 전체보기");
		System.out.println("0. 입력");
		System.out.println("-----------------------");
		System.out.print("선택 : ");
		return sc.nextInt();
	}
	
	public void start() {
		while(true) {
			switch(menu()) {
			case 1:
				addData();
				break;
			case 2:
				getDataAndRemove();
				break;
			case 3:
				getData();
				break;
			case 4:
				showData();
				break;
			case 0:
				System.exit(0);
			
			}
		}
	}
	
	private void showData() {
		System.out.println(queue);
	}

	private void getData() {
		System.out.println(queue.peek());
		
	}

	private void getDataAndRemove() {
		System.out.println(queue.dequeue());
		
	}

	private void addData() {
		System.out.println("입력 값 : ");
		queue.enqueue(sc.next());
	}

	public static void main(String[] args) {
		
		new MyQueueTest().start();

	}

}
