package com.ssafy.Mar.day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static int N,M,V;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new boolean[N+1][N+1];
		int from=0, to=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(rb.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			graph[from][to]=graph[to][from]=true;
		}
		
		visited = new boolean[N+1];
		//visited[V]=true;
		dfs(V);
		
		System.out.println();
		bfs();
		
	}

	private static void dfs(int current) {
		visited[current]=true;
		System.out.print(current+" ");
		
		for(int i=1; i<=N; i++) {
			if(i==current) continue;
			if(graph[current][i] && !visited[i]) {
				dfs(i);
			}
		}
		
	}

	private static void bfs() {
		boolean[] visited = new boolean[N+1];
		visited[V]=true;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int i=1; i<=N; i++) {
				if(i==current) continue;
				if(graph[current][i] && !visited[i]) {
					visited[i]=true;
					queue.offer(i);
				}
			}
			
		}
		
	}

}
