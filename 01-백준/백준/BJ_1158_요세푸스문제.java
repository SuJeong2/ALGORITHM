package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1158_요세푸스문제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N, K;
		
		N=sc.nextInt();
		K=sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++)
			queue.offer(i);
		
		int count=1;
		sb.append("<");
		
		while(!queue.isEmpty()) {
			int value = queue.poll();

			if(count==K) {
				count=1;
				if(!queue.isEmpty()) sb.append(value+", ");
				else sb.append(value);
				continue;
			}
			
			queue.offer(value);
			count++;
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
