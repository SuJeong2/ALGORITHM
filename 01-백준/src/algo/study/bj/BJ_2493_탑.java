package algo.study.bj;

import java.util.Scanner;
import java.util.Stack;

/*
 테스트 케이스
 
입력
5
6 9 5 7 4

출력
0 0 2 2 4
 */

/*
 2021.02.04
 메모리 초과
 */
public class BJ_2493_탑 {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] result = new int[n+1];
		int height = 0, index = 0;
		int[] top = new int[1];

		//height , index값
		Stack<int[]> stack = new Stack<int[]>();
		
		for (int i = 1; i <= n; i++) {

			height = sc.nextInt();

			if (stack.isEmpty()) {
				stack.push(new int[] {height,i});
				result[i] = 0;
			}
			else {

				while (true) {
					top = stack.peek();
					
					if(top[0]<height) {
						stack.pop();
						
						if(stack.isEmpty()) {
							stack.push(new int[] {height, i});
							break;
						}
					}
					
					else {
						result[i]=top[1];
						stack.push(new int[] {height, i});
						break;
					}
					
				}
			}

		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(result[i]+" ");
		}
	}

}
