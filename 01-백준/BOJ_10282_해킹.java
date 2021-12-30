package com.ssafy.Dec.day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10282_해킹 {
	
	static int t, n,d,c,a,b,s;
	static int[] dp;
	static boolean[] visited;
	static ArrayList<Node>[] list;

	static class Node implements Comparable<Node>{
		int number;
		int distance;

		public Node(int n, int s) {
			this.number=n;
			this.distance = s;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(bf.readLine());
		
		for(int T=0; T<t; T++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			dp = new int[n+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			
			list = new ArrayList[n+1];
			for(int i=1; i<=n; i++)
				list[i]=new ArrayList<>();
			
			visited = new boolean[n+1];
			
			for(int D =0; D<d ; D++) {
				st = new StringTokenizer(bf.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				list[b].add(new Node(a,s));
			}
			
			dijkstra(c);
			
			int count=0, max = -1;
			for(int i=1; i<=n; i++) {
				if(visited[i])
					count++;
				if(visited[i]) max = Math.max(max, dp[i]);
			}
			
			System.out.println(count+" "+max);
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		dp[start]=0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(visited[cur.number])
				continue;
			
			visited[cur.number]=true;
			
			for(int i=0; i<list[cur.number].size(); i++) {
				Node next = list[cur.number].get(i);
				
				if(dp[next.number] > dp[cur.number]+next.distance) {
					dp[next.number] = dp[cur.number]+next.distance;
					queue.offer(new Node(next.number, dp[next.number]));
				}
			}
			
			
			
			
		}
		
	}

}
