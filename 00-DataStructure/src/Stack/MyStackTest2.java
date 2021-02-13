package Stack;

import java.util.Scanner;

public class MyStackTest2 {

	Scanner sc = new Scanner(System.in);
	MyStack2<String> stack = new MyStack2<>();
	
	public int menu() {
		System.out.println("메뉴 선택");
		System.out.println("-----------------------");
		System.out.println("1. 입력");
		System.out.println("2. 꺼내기(삭제)");
		System.out.println("3. 꺼내기(유지)");
		System.out.println("4. 전체보기");
		System.out.println("0. 종료");
		System.out.println("-----------------------");
		System.out.print("선택 : ");
		return sc.nextInt();
	}
	
	//push
	private void addData() {
		System.out.println("입력 : ");
		stack.push(sc.next());
	}
	
	//pop
	private void getDataAndRemove() {
		System.out.println("가져온 값 : "+stack.pop());
	}
	
	//peek
	private void getData() {
		System.out.println("가져온 값 : "+stack.peek());
	}
	
	//toString
	private void showData() {
		System.out.println(stack);
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
	
	public static void main(String[] args) {

		new MyStackTest2().start();

	}

}
