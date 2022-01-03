package com.algo2022.Jan.day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {

	static int N,M, max, sum;
	static boolean[] visited;
	static ArrayList<Edge>[] list;
	
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int n=0; n<=N; n++) {
			list[n] = new ArrayList<>();
		}
		
		int A,B,C;
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Edge(B, C));
			list[B].add(new Edge(A, C));
		}
		
		for(int n=0; n<=N; n++) {
			Collections.sort(list[n]);
		}
		
		max = Integer.MIN_VALUE;
		sum=0;
		visited = new boolean[N+1];
		
		Prim(1);
		System.out.println(sum-max);
		
	}

	private static void Prim(int start) {
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start,0));
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(visited[edge.node]) continue;
			else visited[edge.node]=true;
			
			sum+=edge.weight;
			max = Math.max(max, edge.weight);
			
			for(int i=0; i<list[edge.node].size(); i++) {
				Edge next = (Edge) list[edge.node].get(i);
				queue.offer(new Edge(next.node, next.weight));
			}
			
		}
		
	}

}
