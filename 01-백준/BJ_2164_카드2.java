package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164_카드2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++)
			queue.offer(i);
		
		while(queue.size()>1) {
			queue.poll();
			
//			if(queue.size()==1)
//				break;

			
			int top = queue.poll();
			queue.offer(top);
		}
		
		System.out.println(queue.poll());
	}

}
