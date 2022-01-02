package com.algo2022.Jan.day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

	static int N,max,result;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		result = 0;
		for(int i=0; i<=max; i++) { //비가 오지 않는 경우를 고려해서 0부터 시작
			result = Math.max(result, BFS(i));
		}

		System.out.println(result);
	}

	private static int BFS(int i) {
		
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		int count=0;
		
		for(int r=0;r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]>i && !visited[r][c]) {
					count++;
					queue.offer(new int[] {r,c});
					visited[r][c]=true;
					
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						
						for(int dir=0; dir<4; dir++) {
							int nr = cur[0]+dx[dir];
							int nc = cur[1]+dy[dir];
							
							if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
							if(visited[nr][nc]) continue;
							if(map[nr][nc]<=i) continue;
							
							queue.offer(new int[] {nr,nc});
							visited[nr][nc]=true;
						}
					}
					
				}
			}
		}
		
		return count;
	}

}
