package com.algo2022.Jan.day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1414_불우이웃돕기 {

	static int n,sum,total,count;
	static int[][] map;
	static boolean[] visited;
	
	static class Node implements Comparable<Node> {
		int node, weight;

		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<n; j++) {
				char cur = line.charAt(j);
				if(cur=='0') map[i][j]=0;
				else if(cur>=97) map[i][j]=cur-96;
				else map[i][j]=cur-38;
				
				total+=map[i][j];
			}
		}
		
		visited = new boolean[n];
		sum=0;
		count=0;
		int result = prim(0);
		
		System.out.println(result);
	}

	private static int prim(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start,0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(visited[cur.node]) continue;
			else visited[cur.node]=true;
			
			sum+=cur.weight;
			count++; //연결된 컴퓨터의 개수
			
			for(int i=0; i<n; i++) {
				if(map[cur.node][i]==0 && map[i][cur.node]==0) continue;
				int a = map[cur.node][i]==0? Integer.MAX_VALUE : map[cur.node][i];
				int b = map[i][cur.node]==0? Integer.MAX_VALUE : map[i][cur.node];
				queue.offer(new Node(i,Math.min(a, b)));
			}
			
		}
		
		if(count<n) return -1; //모든 컴퓨터가 연결되지 않은 경우
		else return total-sum;
	}

}
