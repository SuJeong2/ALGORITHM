package com.ssafy.Jun.day0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	
	static int n,m, map[][];
	static int visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] =  s.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<n; i++)
			Arrays.fill(visited[i], -1);
		
		Algospot();
		System.out.println(visited[n-1][m-1]);
		
	}

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};

	private static void Algospot() {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,0});
		visited[0][0]=0;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if (cur[2] > visited[cur[0]][cur[1]] && visited[cur[0]][cur[1]]!=-1) continue;
			
			for(int i=0; i<4; i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; //범위 체크
				
				if(visited[nx][ny]==-1) { //아직 방문한 곳이 아닐 경우
					visited[nx][ny]=cur[2]+map[nx][ny];
					queue.offer(new int[] {nx,ny,cur[2]+map[nx][ny]});
				}
				else {
					//방문을 한 곳일 경우, 최소 개수가 될 경우에만 갱신
					int temp = cur[2]+map[nx][ny];
					
					if(visited[nx][ny]>temp) {
						visited[nx][ny]=temp;
						queue.offer(new int[] {nx,ny, temp});
					}
				}
			}
			
		}
		
	}

	

	
}
