package com.algo2022.Jan.day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {

	static int N,M;
	static int[] parents;
	static ArrayList<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int node1, node2, weight;

		public Edge(int node1, int node2, int weight) {
			super();
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}


		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		int a,b,c;
		list = new ArrayList<>();
		for(int m =0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a,b,c));
		}
		
		Collections.sort(list);
		
		parents = new int[N+1];
		for(int n=0; n<=N; n++)
			parents[n]=n;
		
		int sum=0;
		for(int m=0; m<M; m++) {
			Edge edge = list.get(m);
			if(find(edge.node1) != find(edge.node2)) {
				sum+=edge.weight;
				union(edge.node1, edge.node2);
			}
		}
		
		System.out.println(sum);
	}
	
	private static void union(int node1, int node2) {
		node1 = find(node1);
		node2 = find(node2);
		
		if(node1 > node2)
			parents[node1]=node2;
		else parents[node2]=node1;
	}

	private static int find(int node1) {
		if(parents[node1]==node1)
			return node1;
		else return find(parents[node1]);
	}

}
