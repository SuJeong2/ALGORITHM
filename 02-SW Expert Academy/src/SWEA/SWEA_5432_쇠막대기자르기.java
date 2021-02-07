package SWEA;

import java.util.Scanner;
import java.util.Stack;

/*
test case

입력
2
()(((()())(())()))(())
(((()(()()))(())()))(()())


출력
#1 17
#2 24
 */
public class SWEA_5432_쇠막대기자르기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		int count=0, lenght=0, index=0;
		String s=null;
		
		for(int tc = 1; tc <= T; tc++) {
			
			count=0;
			Stack<Integer> stack = new Stack<Integer>();
			//Stack<Integer> stackIndex = new Stack<Integer>();
			
			s=sc.next();
			
			lenght=s.length();
			
			for(int i=0; i<lenght; i++) {
				
				if(stack.isEmpty()) {
					stack.push((int)s.charAt(i));
					//stackIndex.push(i);
					index=i;
				}
				else {
					
					int current = (int)s.charAt(i);
					int top = stack.peek();
					//int topIndex = stackIndex.peek();
					
					//레이저
					if(current-top == 1 && i-index==1) {
						//System.out.println(i+" " + stack.size());
						stack.pop();
						//stackIndex.pop();
						count+=stack.size();
						continue;
					}
					
					//쇠막대기일 경우
					else if(current-top == 1) {
						count+=1;
						stack.pop();
						//stackIndex.pop();
					}
					
					else {
						stack.push(current);
						index=i;
						//stackIndex.push(i);
					}
				}
				
			}
			
			//결과 출력
			System.out.println("#"+tc+" "+count);
		}

	}

}
