package com.ssafy.Apr.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	
	static int N, ans1, ans2;
	static char[][] picture;
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N = Integer.parseInt(st.nextToken());
		
		picture = new char[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String line = rb.readLine();
			for(int j=0; j<N; j++)
				picture[i][j]=line.charAt(j);
		}
		
		//for(int i=0; i<N; i++) System.out.println(Arrays.toString(picture[i]));
		
		ans1=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0) {
					solve(i,j);
					ans1++;
				}
			}
		}
		
		ans2=1;
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0) {
					solve2(i,j);
					ans2++;
				}
			}
		}
		
		System.out.println((ans1-1)+" "+(ans2-1));
	}

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static void solve(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		visited[i][j]= ans1;//방문체크, 그룹 번호로 저장
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
						
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dx[dir];
				int nc = cur[1]+dy[dir];
				
				if(!check(nr, nc) )
					continue;
				if(picture[nr][nc]==picture[cur[0]][cur[1]] && visited[nr][nc]==0) {
					visited[nr][nc]=ans1;
					queue.offer(new int[] {nr,nc});
				}
			}
			
		}
		
	}
	private static void solve2(int i, int j) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		visited[i][j]= ans2;//방문체크, 그룹 번호로 저장
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dx[dir];
				int nc = cur[1]+dy[dir];
				
				if(!check(nr, nc))
					continue;
				
				if(visited[nr][nc]==0) { //방문하지 않은 곳일 경우
					if(picture[cur[0]][cur[1]]=='G' || picture[cur[0]][cur[1]]=='R') {
						if(picture[nr][nc]=='G' || picture[nr][nc]=='R') {
							visited[nr][nc]=ans2;
							queue.offer(new int[] {nr,nc});
						}
					}
					else {
						if(picture[nr][nc]=='B') {
							visited[nr][nc]=ans2;
							queue.offer(new int[] {nr,nc});
						}
					}
				}
			}
			
		}
		
	}

	private static boolean check(int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 ||nc>=N) return false;
		return true;
	}
}
