package com.ssafy.Mar.day0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	
	static int N, K;
	static List<Integer> high;
	static int[][] map;
	static int highest = Integer.MIN_VALUE;
	static ArrayList<int[]> list;
	static int maxLen = Integer.MIN_VALUE;
	
	static boolean visited[][];
	
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(rb.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			highest = Integer.MIN_VALUE; //매 tc마다 가장 작은 값으로 초기화...
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(rb.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>highest) highest = map[i][j]; //가장 높은 봉우리
				}
			}
			//System.out.println(highest);
			list = new ArrayList<int[]>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==highest) {
						list.add(new int[] {i,j}); //가장 높은 봉우리의 위치 저장
						//System.out.println(i+" "+j+" "+map[i][j]);
					}
				}
			}
			
			maxLen = Integer.MIN_VALUE; //결과 값 저장, 가장 작은 수로 초기화
			for(int i=0; i<list.size(); i++) {
				int[] location = list.get(i);
				int r=location[0];
				int c=location[1];
				
				//최고 높은 봉우리도 방문체크 필수 (안해서 전체 테케 64개 중 46개만 맞음)
				visited[r][c]=true;
				DFS(r,c, true, 1);
				visited[r][c]=false;
			}
			
			//결과 출력
			System.out.println("#"+tc+" "+maxLen);
		}
		
	}
	
	public static void DFS(int r, int c, boolean flag, int len) {

		//maxLen=Math.max(maxLen, len);
		
		for(int i=0; i<4; i++) {
			int nr = r+dx[i];
			int nc = c+dy[i];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
			if(visited[nr][nc]==true) continue;
			
			if(map[r][c]>map[nr][nc]) {
				//그냥 갈 수 있는 경우
				visited[nr][nc]=true; //방문체크
				DFS(nr,nc, flag, len+1);
				visited[nr][nc]=false; //방문하고 나서, false로
			}
			else {
				//못 가는 경우
				
				//1.깎을 수 있는 경우
				//2.깎을 순 있어도 높이가 안되는 경우
				if(flag) {
					
					//K 사용 가능할 때,
					//최대 K만큼 깎는다고 했을 때, 낮아지면
					//그리고 0이상, 즉 양수일 때만 깎을 수 있다.
					if(map[nr][nc]-K < map[r][c] && map[nr][nc]>0 ) { 
						int v = map[nr][nc]-map[r][c]+1; //깎아야하는 길이, 무조건 K만큼 깎는 것이 아니라,
														 //지나갈 수만 있도록 최소한으로 깎아줌
						map[nr][nc]-=v;
						
						if(map[nr][nc]<0) map[nr][nc]=0; //이중체크. 음수 값이 되면 0으로
						
						visited[nr][nc]=true; //방문체크
						
						DFS(nr,nc,false, len+1); //K 사용했으니, flag를 false로
						
						map[nr][nc]+=v; //깎은 곳 원래대로 복구
						
						visited[nr][nc]=false; //방문 후
					}
					else {
						maxLen=Math.max(maxLen, len); //더 이상 갈 수 없다. 최댓값 갱신
						//return;
					}
				}
				//3. 깎을 수 없는 경우
				else {
					maxLen=Math.max(maxLen, len); //더 이상 갈 수 없다. 최댓값 갱신
					//return;
				}
				
			}
			
		}
		
	}
}
