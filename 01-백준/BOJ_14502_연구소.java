package com.ssafy.Mar.day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	
	static int N, M;
	static int[][] map;
	static ArrayList<int[]> blank;
	static ArrayList<int[]> virus;
	static int comb;
	static int[] numbers;
	
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		blank = new ArrayList<int[]>();
		virus = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0)
					blank.add(new int[] {i,j});
				if(map[i][j]==2)
					virus.add(new int[] {i,j});
			}
		}
		
		comb=blank.size();
		numbers = new int[3];
		Comb(0,0);
		
		System.out.println(max);
	}

	private static void Comb(int cnt, int start) {
		if(cnt>=3) {
			int[][] temp = mapCopy(map);
			for(int i=0; i<cnt; i++) {
				int[] cur = blank.get(numbers[i]);
				temp[cur[0]][cur[1]] = 1;
			}
			max = Math.max(BFS(temp), max);
			return;
		}
		
		for(int i=start; i<comb; i++) {
			numbers[cnt]=i;
			Comb(cnt+1, i+1);
		}
	}

	private static int[][] mapCopy(int[][] map) {
		int[][] copy = new int[N][M];
		for(int i=0; i<N; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, M);
		}
		return copy;
	}

	private static int BFS(int[][] map) {

		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0; i<virus.size(); i++) {
			int[] temp = virus.get(i);
			queue.offer(new int[] {temp[0], temp[1]});
		}
		
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
			visited[current[0]][current[1]]=true;
			
			for(int i=0; i<4; i++) {
				
				int nr = current[0]+dx[i];
				int nc = current[1]+dy[i];
				
				if(nr<0||nr>=N ||nc<0 ||nc>=M) continue;
				if(map[nr][nc]==1 || map[nr][nc]==2) continue;
				
				//빈공간에 바이러스가 왔을 때
				map[nr][nc]=2;
				queue.offer(new int[] {nr,nc});
				
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}

}
