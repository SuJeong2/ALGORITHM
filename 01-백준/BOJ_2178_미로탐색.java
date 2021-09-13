package com.ssafy.Sep.day0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	static int N, M;
	static int arr[][], MIN[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		MIN = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j)-48;
			}
			Arrays.fill(MIN[i], 99999);
		}
		
		Miro();
		System.out.println(Arrays.deepToString(MIN));
		System.out.println(MIN[N-1][M-1]);
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void Miro() {
		
		Queue<int[]> queue = new LinkedList<>();
		
		MIN[0][0]=1;
		visited[0][0]=true;
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int dir = 0; dir<4; dir++) {
				int nx = cur[0]+dx[dir];
				int ny = cur[1]+dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(arr[nx][ny]==0 || visited[nx][ny]) continue;
				
				MIN[nx][ny]=Math.min(MIN[nx][ny], MIN[cur[0]][cur[1]]+1);
				queue.offer(new int[] {nx,ny});
				visited[nx][ny]=true;
			}
		}
		
	}

}
