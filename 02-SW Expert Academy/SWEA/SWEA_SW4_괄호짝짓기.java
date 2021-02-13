package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_SW4_괄호짝짓기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		
//		int[] arr = {'(', ')', '[', ']', '{', '}', '<','>'};
//		System.out.println(Arrays.toString(arr));

		Stack<Integer> stack = new Stack<Integer>();
		
		for(int tc = 1; tc <=10; tc++) {
			
			int length = sc.nextInt();
			String s = sc.next();
			
			for(int i=0; i<s.length(); i++) {
				
				//스택이 비어있다면 -> 그냥 바로 넣어줌
				if(stack.isEmpty()) {
					stack.push((int) s.charAt(i));
				}
				//비어있지 않을 경우
				/*
				 * 열린 괄호일 경우 그냥 다 넣어줘도 되나?
				 * 
				 * 
				 * 1. 맨 위의 값을 읽어옴
				 * 2. 짝일 경우 pop해버림
				 */
				else {
					int current = (int)s.charAt(i);
					
					//열린 괄호일 경우 그냥 넣어줘도 될 것 같음
					if(current == 40 || current ==91 || current ==123 || current ==60) {
						stack.push(current);
					}
					else {
						//닫힌 괄호일 경우에는 탑을 뽑아서 짝이 맞는지 확인
						int top = stack.peek();
						int dif = current-top;;
						
						// 현재 문자 : )
						if(current == 41) {
							//top 문자가 (
							if(dif==1) {								
								stack.pop();
							}
							//아닐 경우 짝이 안맞으니깐 push
							else {
								stack.push(current);
							}
						}
						
						//그 외 ] } > 문자일 경우
						else {
							//짝이 맞는 경우
							if(dif == 2) {
								stack.pop();
							}
							
							//짝이 맞지 않는 경우
							else {
								stack.push(current);
							}
						}
					}
				}
				
			}
			
			//결과 값 출력
			System.out.print("#"+tc+" ");
			
			//모든 문자를 처리했다면
			if(stack.isEmpty()) System.out.println("1");
			else System.out.println("0");
		}
		
	}

}
