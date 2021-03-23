package com.ssafy.Mar.day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(rb.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] val = new int[N][3];
		int[][] d = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(rb.readLine());
			for(int j=0; j<3; j++) {
				val[i][j] = Integer.parseInt(st.nextToken());
				if(i==0) d[i][j]=val[i][j];
			}
		}
		
		for(int i=1 ; i<N; i++) {
			for(int j=0; j<3; j++) {
				if(j==0) d[i][j]=Math.min(d[i-1][1], d[i-1][2])+val[i][j];
				if(j==1) d[i][j]=Math.min(d[i-1][0], d[i-1][2])+val[i][j];
				if(j==2) d[i][j]=Math.min(d[i-1][0], d[i-1][1])+val[i][j];
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<3; i++)
			ans = Math.min(ans, d[N-1][i]);
		
		System.out.println(ans);
	}

}
