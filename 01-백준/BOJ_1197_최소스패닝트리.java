package com.algo2022.Jan.day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {

	static int V,E;
	static int[] parents;
	static ArrayList<Edge> list;
	
	static class Edge implements Comparable<Edge>{
		int node1,node2,weight;
		public Edge(int a, int b, int c) {
			node1=a;
			node2=b;
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
		
		parents = new int[V+1];
		list = new ArrayList<Edge>();
		int A,B,C;
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(A,B,C));
		}
		
		Collections.sort(list);
		
		for(int v=1; v<=V; v++) {
			parents[v]=v;
		}
		
		int sum=0;
		for(int e=0; e<E; e++) {
			Edge edge = list.get(e);
			if(find(edge.node1) != find(edge.node2)) {
				sum+=edge.weight;
				union(edge.node1, edge.node2);
			}
		}
		
		System.out.print(sum);
		
	}

	private static void union(int node1, int node2) {

		node1 = find(node1);
		node2 = find(node2);
		
		if(node1>node2)
			parents[node1] = node2;
		else parents[node2] = node1;
	}

	private static int find(int node1) {
		if(parents[node1]==node1)
			return node1;
		
		else return find(parents[node1]);
	}

}
