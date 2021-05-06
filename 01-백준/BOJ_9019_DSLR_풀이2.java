package com.ssafy.May.day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR_풀이2 {

	static int A, B;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			System.out.println(getMinCal(A,B));
		}

	}

	private static String getMinCal(int A, int B) {
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		queue.offer(A);
		queue2.offer("");
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			String cur2 = queue2.poll();
			
			int temp = cur;
			if(visited[temp]) continue;
			
			visited[temp] = true;
				
			if(cur== B) {
				return cur2;
			}
			
			//같지 않다면 4가지의 계산을 해야 한다.
			
			//D연산
			queue.offer((temp*2)%10000);
			queue2.offer(cur2+"D");
			
			//S연산
			queue.offer((temp-1<0? 9999 : temp-1));
			queue2.offer(cur2+"S");
			
			//L연산
			int Ltemp = temp;
			Ltemp = (temp%1000)*10 + (temp/1000);
			queue.offer(Ltemp);
			queue2.offer(cur2+"L");
			
			//R연산
			int Rtemp = temp;
			Rtemp = (temp/10) + (temp%10)*1000;
			queue.offer(Rtemp);
			queue2.offer(cur2+"R");
		}
		
		
		return null;
	}
}
