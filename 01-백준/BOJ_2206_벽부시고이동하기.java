package com.ssafy.Mar.day0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc {
	int r, c, len, breakCnt;

	public Loc(int r, int c, int len, int breakCnt) {
		super();
		this.r = r;
		this.c = c;
		this.len = len;
		this.breakCnt = breakCnt;
	}

}

public class BOJ_2206_벽부시고이동하기 {

	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans = -1;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String s = rb.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (int) s.charAt(j) - '0';
			}
		}

		// 도착점
		N--;
		M--;
		
		BFS(0, 0);

		//결과 출력
		System.out.println(ans);
	}

	private static void BFS(int i, int j) {
		
		Queue<Loc> queue = new LinkedList<Loc>();
		
		queue.offer(new Loc(i,j,0,0));
		visited[i][j][0]=true;
		
		while(!queue.isEmpty()) {
			
			Loc current = queue.poll();
			
			if(current.r==N && current.c==M) { //도착지점에 왔을 경우, 최대값 비교
				ans = Math.max(ans, current.len+1);
				return;
			}
			
			for(int dir = 0; dir<4; dir++) {
				int nr = current.r + dx[dir];
				int nc = current.c + dy[dir];
				
				if(nr<0 || nr>N || nc<0 || nc>M) continue; //범위체크
				if(visited[nr][nc][current.breakCnt]) continue; //방문했으면 continue
				
				visited[nr][nc][current.breakCnt]=true; //방문체크

				if(map[nr][nc]==0) { //벽이 아닐 경우
					queue.offer(new Loc(nr,nc,current.len+1, current.breakCnt));
					continue;
				}
				
				if(map[nr][nc]==1) { //벽일 경우
					if(current.breakCnt==0) { //벽 부술 기회 있을 때만 가능
						queue.offer(new Loc(nr,nc, current.len+1, 1));
						continue;
					}
				}
			}
			
		}
		
	}

}
