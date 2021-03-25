package com.ssafy.Mar.day0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

	static int T, N;
	static int[][] location;
	static int[][] adjMatrix;
	static int INF = 9999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(rb.readLine());
			N = Integer.parseInt(st.nextToken());
			
			location = new int[N+2][2];
			adjMatrix = new int[N+2][N+2];
			
			//상근이네
			st = new StringTokenizer(rb.readLine());
			location[0][0] = Integer.parseInt(st.nextToken());
			location[0][1] = Integer.parseInt(st.nextToken());
			
			//편의점
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(rb.readLine());
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//페스티벌
			st = new StringTokenizer(rb.readLine());
			location[N+1][0] = Integer.parseInt(st.nextToken());
			location[N+1][1] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N+2; i++) {
				for(int j=i; j<N+2; j++) {
					if(i==j) {
						adjMatrix[i][j]=0;
						continue;
					}
					//거리계산 + 맥주 가능한지
					int len = Math.abs(location[i][0]-location[j][0]) 
							+ Math.abs(location[i][1]-location[j][1]);
					//int beer = len / 50;
					if(len>1000) {
						adjMatrix[i][j]=INF;
						adjMatrix[j][i]=INF;
					}
					else {
//						adjMatrix[i][j]=beer;
//						adjMatrix[j][i]=beer;
						adjMatrix[i][j]=1;
						adjMatrix[j][i]=1;
					}
				}
			}
			
			for(int k=0; k<N+2; ++k) {
				for(int i=0; i<N+2; ++i) {
					if(i==k) continue;
					for(int j=0; j<N+2; ++j) {
						if(i==j || k==j) continue;
						if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
						}
					}
				}
			}
			
			//결과
			System.out.println( (adjMatrix[0][N+1]>0 && adjMatrix[0][N+1]<INF)? "happy" : "sad" );
		}
	}

}
