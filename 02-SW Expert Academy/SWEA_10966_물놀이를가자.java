package com.ssafy.Mar.day0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_10966_물놀이를가자 {

	static int N, M;
	
	static char[][] map;
	static int[][] visited;
	static Queue<int[]> queue;
	
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(rb.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			map=new char[N][M];
			visited = new int[N][M];

			for(int i=0; i<N; i++) {
				map[i]=rb.readLine().toCharArray();
			}
			
			queue = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]=='W') {
						queue.offer(new int[] {i,j});
					}
				}
			}
			
			BFS();
			
			int sum=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]!=0) {
						sum+=visited[i][j];
					}
				}
			}
			//sum=Arrays.stream(visited).sum();
			//System.out.println(Arrays.deepToString(visited));
			
			//결과
			System.out.println("#"+tc+" "+sum);
		}
	}
	
	public static void BFS() {

		
		while(!queue.isEmpty()) {
			int[] temp=queue.poll();
			int r1 = temp[0];
			int c1 = temp[1];
			
			for(int i=0; i<4; i++) {
				int nr = r1+dx[i];
				int nc = c1+dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				
				if(map[nr][nc]=='W') continue;
				
				if(visited[nr][nc]>0) continue;
				
				//방문한 적이 없는 경우
				visited[nr][nc]=visited[r1][c1]+1;
				queue.offer(new int[] {nr,nc});

			}
		}
	}
}
