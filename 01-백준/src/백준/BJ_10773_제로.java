package 백준;

import java.util.Scanner;
import java.util.Stack;

public class BJ_10773_제로 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n, k;
		k = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0 ;i<k; i++) {
			n = sc.nextInt();
			
			if(n==0) {
				stack.pop();
			}
			else
				stack.push(n);
		}
		
		int sum=0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		
		System.out.println(sum);
	}
}
