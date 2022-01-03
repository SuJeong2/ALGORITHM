package com.algo2022.Jan.day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {

	private static final int INF = 200000000;
	static int V,E, v1, v2, sum1, sum2;
	static ArrayList[] list;
	static int[] dp;
	static boolean[] visited;
	
	static class Edge implements Comparable<Edge>{
		int node, weight;

		public Edge(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dp = new int[V+1];
		
		list = new ArrayList[V+1];
		for(int v=0; v<=V; v++) {
			list[v] = new ArrayList<>();
		}
		
		int a,b,c;
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,c));
			list[b].add(new Edge(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		sum1=0;
		sum2=0;
		
		//1. 1 -> v1 -> v2 -> N
		int sum1 = Dijkstra(1, v1)+Dijkstra(v1,v2)+Dijkstra(v2, V);
		
		//2. 1 -> v2 -> v1 -> N
		int sum2 = Dijkstra(1, v2)+Dijkstra(v2,v1)+Dijkstra(v1, V);
		
		if(sum1 >= INF && sum2 >= INF) System.out.println(-1);
		else System.out.println(Math.min(sum1, sum2));
	}

	private static int Dijkstra(int start, int end) {

		Arrays.fill(dp, INF);
		visited = new boolean[V+1];
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start, 0));
		dp[start]=0;
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(visited[edge.node]) continue;
			
			visited[edge.node] = true;
			
			for(int i=0; i<list[edge.node].size(); i++) {
				Edge next = (Edge) list[edge.node].get(i);
				
				if(dp[next.node]>dp[edge.node]+next.weight) {
					dp[next.node]=dp[edge.node]+next.weight;
					queue.offer(new Edge(next.node, dp[next.node]));
				}
			}
			
		}
		
		return dp[end];
	}

}
