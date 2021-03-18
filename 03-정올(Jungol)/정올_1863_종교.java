package com.ssafy.Mar.day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1863_종교 {

	static int N, M, i, j;
	static int[] parents;
	static int[] rank;
	
	static boolean[] check;
	
	static void make() {
		for(int i=1; i<=N; i++) {
			parents[i]=i;
			rank[i]=0;
		}
	}
	static int findSet(int i2) {
		if(parents[i2]==i2) return i2;
		return parents[i2]=findSet(parents[i2]);
	}
	
	static void union(int i, int j) {
		int iRoot = findSet(i);
		int jRoot = findSet(j);
		
		if(iRoot == jRoot) return;
		
		if(rank[iRoot]<rank[jRoot]) {
			parents[iRoot]=jRoot;
		}
		else {
			parents[jRoot]=iRoot;
			if(rank[iRoot]==rank[jRoot]) {
				rank[iRoot]++;
			}
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		rank = new int[N+1];
		check = new boolean[N+1];
		
		make();
		
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(rb.readLine());
			i=Integer.parseInt(st.nextToken());
			j=Integer.parseInt(st.nextToken());
			
			union(i,j);
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(parents[i]==i) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}


}
