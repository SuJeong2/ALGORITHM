package com.ssafy.Apr.day0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static int N;
	static int[][] map, dijk;
	
	static int[] dx= {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc =1;
		while((N=Integer.parseInt(br.readLine()))!=0) {
			
			map=new int[N][N];
			dijk=new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					dijk[i][j]=Integer.MAX_VALUE;
				}
			}
			
			System.out.println("Problem "+(tc++)+": "+getResult());
			
		}

	}

	private static int getResult() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		dijk[0][0]=map[0][0];
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dx[dir];
				int nc = cur[1]+dy[dir];
				
				if(check(nr,nc) && dijk[nr][nc]>dijk[cur[0]][cur[1]]+map[nr][nc]) {
					dijk[nr][nc]=dijk[cur[0]][cur[1]]+map[nr][nc];
					queue.offer(new int[] {nr,nc});
				}
				
			}
			
		}
		
		
		return dijk[N-1][N-1];
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}

}
