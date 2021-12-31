package com.ssafy.Dec.day1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

	static int n,a,b,m,x,y, result;
	static ArrayList[] family;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		family = new ArrayList[n+1];
		for(int N=0; N<=n; N++) {
			family[N] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		for(int M=0; M<m; M++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			family[x].add(y);
			family[y].add(x);
		}
		
		DFS(a,b,0);
		System.out.print(flag? result : -1);
		
	}

	private static void DFS(int a, int b, int count) {
		
		
		if(a==b) {
			result = count;
			flag=true;
			return ;
		}
		
		visited[a]=true;

		for(int i=0; i<family[a].size() && !flag; i++) {
			int node = (int) family[a].get(i);
			
			if(!visited[node]) {
				DFS(node, b, count+1);
			}
		}
		
		return ;
	}

}
