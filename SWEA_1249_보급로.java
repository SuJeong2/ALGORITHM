package com.ssafy.AlgoSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1249_보급로 {

	static int N,MIN;
	static int[][] map;
	static int[][] temp;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(rb.readLine());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				String line = rb.readLine();
				for(int j=0; j<N; j++)
					map[i][j]= (int)line.charAt(j)-'0';
			}
			
			
			visited = new boolean[N][N];
			visited[0][0] = true;
			
			temp = new int[N][N];
			
			for(int i=0; i<N; i++)
				Arrays.fill(temp[i], Integer.MAX_VALUE);
		
			temp[0][0]=0;

			MIN = Integer.MAX_VALUE;
			BFS(0,0);
			
			sb.append("#"+tc+" ").append(temp[N-1][N-1]).append("\n");
		}

		System.out.println(sb.toString());
	}

	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
			int[] temps = queue.poll();
			
			for(int dir=0; dir<4; dir++) {
				int nr = temps[0]+dx[dir];
				int nc = temps[1]+dy[dir];
				
				if(check(nr,nc))
					if(temp[temps[0]][temps[1]]+map[temps[0]][temps[1]]<temp[nr][nc]) {
					temp[nr][nc]=temp[temps[0]][temps[1]]+map[temps[0]][temps[1]];
					queue.offer(new int[] {nr,nc});
				}
				
			}
			
			
		}
		
		
	}

	private static boolean check(int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 || nc>=N ) return false;
		return true;
	}

}
