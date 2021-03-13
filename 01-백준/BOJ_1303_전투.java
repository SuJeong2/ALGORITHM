package com.ssafy.Mar.day0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1303_전투 {

	static int ansW;
	static int ansB;
	static int N,M, cnt;
	static char[][] war;
	static boolean[][] visited;
	
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		ansW=0;
		ansB=0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		war = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			war[i]=rb.readLine().toCharArray();
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt=1;
					DFS(i,j);
					if(war[i][j]=='W') ansW += (int)Math.pow(cnt, 2);
					else ansB += (int)Math.pow(cnt, 2);
				}
			}
		}
		
		System.out.println(ansW +" "+ansB);
	}
	
	public static void DFS(int r, int c) {
		
		visited[r][c]=true;
		
		for(int i=0; i<4; i++) {
			int nr=r+dx[i];
			int nc=c+dy[i];
			
			if(nr<0 || nr>=M|| nc<0 || nc>=N) continue;
			
			if(visited[nr][nc] || war[nr][nc]!=war[r][c]) continue;
			
			//방문도 안하고  같은 팀일 경우
			DFS(nr,nc);
			cnt++;
		}
			
	}
}
