package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*
BufferedReader로 시간초과, 메모리 초과 문제 해결
 */
public class BJ_2493_탑 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = reader.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		
		int[] result = new int[n+1];
		int height = 0, index = 0;
		int[] top = new int[1];

		//height , index값
		Stack<int[]> stack = new Stack<int[]>();
		
		st = new StringTokenizer(reader.readLine());
		
		for (int i = 1; i <= n; i++) {

			height = Integer.parseInt(st.nextToken());

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
