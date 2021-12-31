package com.ssafy.Dec.day1231;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {

	static int n, k, result;
	static int[] list;
	
	static class Info{
		int time;
		int position;
		public Info(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		list = new int[100002];
		Arrays.fill(list, Integer.MAX_VALUE);
		
		BFS(n,k);
		
		System.out.println(list[k]);
	}

	private static void BFS(int n, int k) {
		
		Queue<Info> queue = new LinkedList<>();
		queue.offer(new Info(n,0));
		
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			
			if(list[cur.position]<=cur.time) continue;
			list[cur.position] = cur.time;
			
			if(cur.position+1<=100000) queue.offer(new Info(cur.position+1, cur.time+1));
			if(cur.position-1>=0) queue.offer(new Info(cur.position-1, cur.time+1));
			if(cur.position*2<=100000) queue.offer(new Info(cur.position*2, cur.time+1));
		}
		
		
	}

}
