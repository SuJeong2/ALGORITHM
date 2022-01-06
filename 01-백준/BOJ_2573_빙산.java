package com.algo2022.Jan.day0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0, year=0;
		do {
			melt();
			year++;
			count = getCount();
			if(count==0 || count>=2) break;
		}while(true);
		
		System.out.println(count==0? 0 : year);
	}

	private static void melt() {
		
		int[][] count_map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]<=0) continue;
				
				int cnt=0;
				for(int dir=0; dir<4; dir++) {
					int nx = i+dx[dir];
					int ny = j+dy[dir];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					if(map[nx][ny]<=0) cnt++;
				}
				
				count_map[i][j] = cnt;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]-=count_map[i][j];
			}
		}
	}

	private static int getCount() {
		
		int cnt=0;
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] || map[i][j]<=0) continue;
				
				cnt++;
				
				Queue<int[]> queue = new LinkedList<>();
				queue.offer(new int[] {i,j});
				visited[i][j] = true;
				
				while(!queue.isEmpty()) {
					int[] cur = queue.poll();
					
					for(int dir=0; dir<4; dir++) {
						int nx = cur[0]+dx[dir];
						int ny = cur[1]+dy[dir];
						
						if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
						if(visited[nx][ny] || map[nx][ny]<=0) continue;
						
						queue.offer(new int[] {nx,ny});
						visited[nx][ny]=true;
					}
				}
			}
		}
		
		return cnt;
	}

}
