package com.ssafy.Jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {

	static int n, k, map[][];
	
	static int[] dx = {0, 0,0,-1,1};
	static int[] dy = {0, 1,-1,0,0};
	
	static ArrayList<Horse> horse;
	static LinkedList<Integer>[][] count;
	
	static boolean flag = false;
	static int ans = 0;
	
	static class Horse{
		int r, c, dir;

		public Horse(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n]; //0,1,2 - 각 위치의 색을 저장하는 맵 정보
		count = new LinkedList[n][n]; //각 위치에 있는 말의 순서를 저장하기 위해
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				count[i][j] = new LinkedList<>();
		}
		
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<n; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		horse = new ArrayList<Horse>(); //1부터 K번까지의 말 정보를 ArrayList에 저장해서 관리
		for(int K=0; K<k; K++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			
			count[r][c].add(K); //(r,c)위치에 해당 말 번호를 저장
			
			horse.add(new Horse(r,c,dir)); //말 리스트에도 저장
		}
		
		for(int i=1; i<1000 && !flag; i++) { //중간에 말 4개가 겹치면 flag값을 true로 바꿈
			play();
			ans++; //turn 횟수
		}
		
		System.out.println(flag ? ans : -1); //결과 출력
	}

	private static void play() {
		
		for(int i=0; i<horse.size(); i++) {//1번부터 K번까지의 말을 옮김
			
			Horse h = horse.get(i);
			
			int nr = h.r+dx[h.dir];
			int nc = h.c+dy[h.dir];
			
			if(nr>=n || nr<0 || nc>=n || nc<0 || map[nr][nc]==2) { //체스판을 벗어나거나 파란색일 경우
				changeDir(i); //방향 변경
				
				//방향을 바꾼 다음의 위치
				nr = h.r+dx[h.dir];
				nc = h.c+dy[h.dir];
			}
			
			//범위 밖이거나 파란색이면 이동하지 않고 넘어감
			if(nr>=n || nr<0 || nc>=n || nc<0 || map[nr][nc]==2) continue; 
			
			int loc = count[h.r][h.c].indexOf(i); //현재 위치에 말이 몇 번째에 올려져 있는지
			int cnt = count[h.r][h.c].size(); //현재 위치에 있는 말의 개수
			int tempR = h.r;
			int tempC = h.c;
			int temp;
			//현재 말 + 그 위에 있는 말들만 옮길 수 있기 때문에
			ArrayList<Integer> list = new ArrayList<Integer>(); //옮길 말의 정보를 담음

			if(map[nr][nc]==1) { //빨간색일 경우
				for(int j=loc; j<cnt; j++) {
					//현재 말 번호부터 그 위에 쌓인 말의 번호를 리스트에 저장
					temp = count[tempR][tempC].get(j);
					list.add(temp);
					
					//말의 위치 정보를 바꿔주기
					Horse tempH = horse.get(temp);
					tempH.r=nr;
					tempH.c=nc;
				}
				
				//리스트에 있는 값을 뒤에서부터 읽음 -> 빨간색 땅이라 거꾸로 말을 거꾸로 쌓으려고
				for(int k=list.size()-1; k>=0 ; k--) {
					count[tempR][tempC].remove(list.get(k)); //원래 있던 곳에는 해당 말을 없애기
					count[nr][nc].add(list.get(k)); //옮기는 위치에 말을 쌓기
				}
			}
			
			if(map[nr][nc]==0) {
				for(int j=loc; j<cnt; j++) {
					//현재 말 번호부터 그 위에 쌓인 말의 번호를 리스트에 저장
					temp = count[tempR][tempC].get(j);
					list.add(temp);
					
					//말의 위치 정보를 바꿔주기
					Horse tempH = horse.get(temp);
					tempH.r=nr;
					tempH.c=nc;
				}

				//리스트에 있는 값을 읽으면서 새로운 위치에 추가하고(쌓고), 원래 있던 곳에서는 없애준다
				for(int k=0; k<list.size() ; k++) {
					count[tempR][tempC].remove(list.get(k)); //원래 있던 곳에는 해당 말을 없애기
					count[nr][nc].add(list.get(k)); //옮기는 위치에 말을 쌓기
				}
			}
			
			//만약 말을 옮긴 곳에 말이 4개 이상 있을 경우
			if(count[nr][nc].size()>=4) {
				flag=true; //flag 값을 true로 바꾸고
				return; //함수 종료
			}
		}
		
	}

	private static void changeDir(int i) {
		//해당 번호의 말을 꺼내서, dir 정보를 바꿔준다
		Horse h = horse.get(i);
		
		if(h.dir%2==0) {
			h.dir -=1;
		}
		else h.dir+=1;
	}

}
