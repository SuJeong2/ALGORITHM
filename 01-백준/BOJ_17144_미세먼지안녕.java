package com.ssafy.Apr.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {

	static int R,C,T;
	static int[][] map;
	static ArrayList<Loc> air;
	static ArrayList<Loc> dust;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static int[][] dx1 = {{-1,0,1,0},{1,0,-1,0}};
	static int[][] dy1 = {{0,1,0,-1},{0,1,0,-1}};
	
	static class Loc{
		int r,c, dust;

		public Loc(int r, int c, int dust) {
			super();
			this.r = r;
			this.c = c;
			this.dust = dust;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		T = Integer.parseInt(st.nextToken()); //시간
		
		map=new int[R][C]; //미세먼지 정보
		air = new ArrayList<Loc>(); //공기청정기가 있는 위치 저장
		dust = new ArrayList<Loc>(); //미세먼지가 있는 위치 저장
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=0; j<C; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) air.add(new Loc(i,j, map[i][j]) ); //공기청정기 위치 저장
			}
		}
		
		
		for(int time=1; time<=T; time++) {
			getDustLoc(); //현재 time에 미세먼지가 있는 위치 파악
			airPollution(); //미세먼지 확산
			airClean(); //공지청정기
		}
		
		//결과
		System.out.println(getTotalDust());
	}

	/**
	 * 미세먼지 위치를 파악하는 함수
	 * 미세먼지인 경우, dust 리스트에 (r,c,미세먼지 양) 정보 저장
	 */
	private static void getDustLoc() {
		dust.clear(); //기존에 있는 dust 정보는 지우고 새로 저장
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==-1 || map[i][j]==0) continue; //공기청정기이거나 미세먼지가 없는 경우
				
				dust.add(new Loc(i,j, map[i][j])); //미세먼지 위치 정보 저장
			}	
		}
		
	}

	/**
	 * 미세먼지 확산 함수
	 * 현재 미세먼지 양을 가지고 4방 체크 후, 확산
	 */
	private static void airPollution() {
		
		for(int i=0; i<dust.size(); i++) {
			Loc cur = dust.get(i);
			
			int dustAmount = cur.dust/5; //확산 양
			int spreadCnt = 0; //확산된 방향 수
			
			for(int dir=0; dir<4; dir++) {
				int nr = cur.r+dx[dir];
				int nc = cur.c+dy[dir];
				
				if(check(nr,nc)) { //맵의 범위일 때만 확산
					if(map[nr][nc]==-1) continue; //공기청정기 위치면 확산 X
					
					spreadCnt++;
					map[nr][nc]+=dustAmount;
				}
			}
			
			//확산 후, 현재 위치 미세먼지 값 변경
			map[cur.r][cur.c]-=dustAmount*spreadCnt;
		}
	}

	/**
	 * 공기청정기 작동 함수
	 * 공지청정기 위치부터 한칸씩 앞으로 땡겨준다.
	 */
	private static void airClean() {
		for(int i=0; i<2; i++) {
			Loc air1 = air.get(i);
			int r = air1.r;
			int c = air1.c;
			
			for(int dir = 0 ; dir<4; dir++) {
				while(true) {
					r = r+dx1[i][dir];
					c = c+dy1[i][dir];
					
					if(!check(r,c) || (dir==2 && r==air1.r+dx1[i][dir])) {
						r-=dx1[i][dir];
						c-=dy1[i][dir];
						break;
					}
					
					if(map[r][c]==-1) continue; //공기청정기인 경우
					
					if(map[r-dx1[i][dir]][c-dy1[i][dir]]==-1) { //앞의 칸이 공기청정기인 경우
						map[r][c]=0; //현재 위치만 0으로 바꾸고 계속
						continue;
					}
					
					map[r-dx1[i][dir]][c-dy1[i][dir]]=map[r][c]; //앞으로 한칸 땡김
					map[r][c]=0; //현재 위치는 0으로 비워줌
					
				}
				
			}
			
		}
	}

	/**
	 * 남아있는 미세먼지 양을 계산하는 함수
	 * @return 남은 미세먼지양
	 */
	private static int getTotalDust() {
		int count=0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==-1 || map[i][j]==0) continue;
				count+=map[i][j];
			}
		}
		return count;
	}
	
	/**
	 * 4방 범위 체크
	 * @param nr 행
	 * @param nc 열
	 * @return 범위 안이면 true, 범위 밖이면 false
	 */
	private static boolean check(int nr, int nc) {
		if(nr<0 || nr>=R || nc<0 ||nc>=C) return false;
		return true;
	}

}
