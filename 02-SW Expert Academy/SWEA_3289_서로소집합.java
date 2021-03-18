package com.ssafy.Mar.day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	
	static int N, M;
	static int[] parents;
	static int operation, a,b;
	
	static void makeSet() {
		for(int i=1; i<=N; i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a]=findSet(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) return;
		
		parents[bRoot]=aRoot;
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(rb.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			parents= new int[N+1];
			makeSet();
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(rb.readLine());
				operation=Integer.parseInt(st.nextToken());
				a=Integer.parseInt(st.nextToken());
				b=Integer.parseInt(st.nextToken());
				
				//합치기 연산
				if(operation==0) {
					union(a,b);
				}
				
				else {
					if(findSet(a)!=findSet(b)) System.out.print(0);
					else System.out.print(1);
				}
			}
			
			System.out.println();
		}
	}
}
