package com.ssafy.Jun.day0616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {

	static int n, area[][], v[][], ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		area = new int[n][n];
		v = new int[n][n];
		
		for(int i=0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(v[i][j]==0) { //이미 최대 값이 정해진 위치일 경우 탐색 X
					DFS(i,j);
				}
			}
		}
		
		System.out.println(ans);
	}

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static int DFS(int r, int c) {
		if(v[r][c]!=0) return v[r][c];
		
		for(int i=0; i<4; i++) {
			int nr = r+dx[i];
			int nc = c+dy[i];
			
			if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
			
			if(area[nr][nc]>area[r][c]) {
				//이동 가능
				v[r][c] = Math.max(v[r][c], DFS(nr,nc)+1); //현재 위치와 비교해서 더 큰 값으로 바꿔줌
			}
			else {
				v[r][c] = Math.max(v[r][c], 1); //이동할 수 없는 경우, 현재 값이나 1 중에 큰 값으로
				//현재 위치에서 다른 곳으로 이동해서 갈 수 있는 길 vs 이 자리에만 있을 수 있는 경우(하루만 버틸 수 있음)
			}
			
		}
		
		ans = Math.max(ans, v[r][c]);
		return v[r][c];
	}
}
