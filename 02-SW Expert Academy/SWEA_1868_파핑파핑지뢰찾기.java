package com.ssafy.Apr.day0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {

	static char[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int N, click;
	static int[] dx = {0,0,-1,1, -1,-1,1,1};
	static int[] dy = {1,-1,0,0,-1,1,1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			click=0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			count = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j]=line.charAt(j);
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='*') {
						count[i][j]=-1;
						continue;
					}
					
					//지뢰가 아닐 경우 - 8방 탐색
					int cnt=0; //8방에 있는 지뢰 개수
					
					for(int dir=0; dir<8; dir++) {
						int nr = i+dx[dir];
						int nc = j+dy[dir];
						
						if(check(nr, nc) && map[nr][nc]=='*') {
							cnt++;
						}
					}
					
					count[i][j]=cnt;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(count[i][j]==0 && !visited[i][j]) {
						BFS(i,j);
						click++;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(count[i][j]>0 && !visited[i][j]) {
						click++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+click);
		}
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		visited[i][j]=true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(!visited[cur[0]][cur[1]])click++;
			
			visited[cur[0]][cur[1]]=true;
			
			for(int dir=0; dir<8; dir++) {
				int nr = cur[0]+dx[dir];
				int nc = cur[1]+dy[dir];
				
				if(check(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc]=true;
				
					if(count[nr][nc]==0) queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	private static boolean check(int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 || nc>=N) return false;
		return true;
	}

}
