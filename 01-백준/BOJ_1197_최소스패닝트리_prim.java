package com.algo2022.Jan.day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리_prim {

	static int V,E,sum;
	static boolean[] visited;
	static ArrayList<Edge>[] list;
	
	static class Edge implements Comparable<Edge>{
		int node1, weight;
		public Edge(int a, int c) {
			node1=a;
			weight=c;
		}
		@Override
		public int compareTo(Edge o) {
			Integer x = this.weight;
			Integer y = o.weight;
			return x.compareTo(y);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		for(int v=0; v<=V; v++) {
			list[v]=new ArrayList<>();
		}
		
		int A,B,C;
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Edge(B,C));
			list[B].add(new Edge(A,C));
		}
		
		for(int v=0; v<=V; v++) {
			Collections.sort(list[v]);
		}
		
		sum=0;
		prim(1);
		
		System.out.print(sum);
		
	}

	private static void prim(int start) {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(start, 0));
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			
			if(visited[edge.node1]) continue;
			else visited[edge.node1]=true;
			
			sum+=edge.weight;
			
			for(int i=0; i<list[edge.node1].size(); i++) {
				Edge next = list[edge.node1].get(i);
				queue.offer(new Edge(next.node1, next.weight));
			}
		}
	}

}
