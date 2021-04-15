package com.ssafy.Apr.day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

	static int N,M,R,C,L, cnt;
	static int[][] map;
	static boolean[][] visited;
	
						// 0  1상하좌우	  2상하	  3좌우	  4상우	 5하우	6하좌		7 상좌
	static int[][] dx = { {}, {0,0,1,-1}, {-1,1} ,{0,0}, {-1,0}, {0,1}, {0,1}, {0,-1} };
	static int[][] dy = { {}, {1,-1,0,0}, {0,0} ,{1,-1}, {0,1}, {1,0}, {-1,0}, {-1,0} };
	
	static class Info{
		int r, c, pipe, time;

		public Info(int r, int c, int pipe, int time) {
			super();
			this.r = r;
			this.c = c;
			this.pipe = pipe;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}

			solve(new Info(R,C,map[R][C],1));

			//결과
			System.out.println("#"+tc+" "+getVisted());
		}
		
	}

	private static int getVisted() {
		cnt=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				if(visited[i][j]) cnt++;
		}
		return cnt;
	}

	private static void solve(Info info) {
		Queue<Info> queue = new LinkedList<Info>();
		visited[info.r][info.c]=true;
		queue.offer(info);
		
		while(!queue.isEmpty()) {
			Info cur = queue.poll();
			
			int pipe = cur.pipe;
			if(pipe==0) continue;
			
			for(int i=0; i<dx[pipe].length; i++) {
				int nr = cur.r+dx[pipe][i];
				int nc = cur.c+dy[pipe][i];
				
				if(!check(nr,nc) || visited[nr][nc]) continue;
				
				//파이프가 연결되는지 확인하기
				boolean flag=false;
				int nextPipe = map[nr][nc]; 
				for(int k=0; k<dx[nextPipe].length; k++) {
					int tempR = nr + dx[nextPipe][k];
					int tempC = nc + dy[nextPipe][k];
					
					if(tempR==cur.r && tempC==cur.c) {
						flag=true;
						break;
					}
				}
				
				if(flag) { //파이프가 연결되어 있다면 큐에 추가
					if(cur.time+1<=L) {
						visited[nr][nc]=true;
						queue.offer(new Info(nr,nc,map[nr][nc],cur.time+1));	
					}
				}
				
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 ||nc>=M) return false;
		return true;
	}


}
