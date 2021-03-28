package com.ssafy.Mar.day0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {

	static int N;
	static int[][] result;
	static int[] numbers;
	static boolean[] visited;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N = Integer.parseInt(st.nextToken());
		result = new int[N][10];
		numbers = new int[10];
		visited = new boolean[10];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=1; j<=9; j++) {
				result[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		//4번 타자는 1번 선수로 고정
		numbers[4]=1;
		visited[1]=true;
		
		//순열
		Perm(1);
		
		System.out.println(ans);
	}

	private static void Perm(int cnt) {
		
		if(cnt>9) {
			//야구 선수단 순서 다 만들어짐
			//System.out.println(Arrays.toString(numbers));
			play();
			return;
		}
		
		for(int i=1; i<=9; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			
			if(cnt==4) {
				cnt+=1;
			}
		
			numbers[cnt]=i;
			Perm(cnt+1);

			visited[i]=false;
		}
		
	}

	private static void play() {
		
		int outCnt=0; //아웃 개수 카운팅
		
		int index=1; //numbers의 인덱스 값 : 타순
		int player=0; //해당 타순의 선수 번호
		
		int score=0; //점수
		int inning=0; //이닝 카운팅
		
		boolean[] ground =new boolean[4]; //1,2,3루에 선수가 있는지 표시하기 위함
		
		
		while(true) {
			
			if(inning>=N) break; //게임 종료
			
			while(outCnt<3) {
				if(index==10)
					index=1; //9번 선수 -> 1번 선수
				
				player = numbers[index++]; //현재 타자의 번호
				
				int i = result[inning][player]; //현재 타자의 결과
				switch(i) {
				
				case 1: //안타일 경우 - 1루 진출
					if(ground[3]) {
						score++; //3루 선수있을 경우, 점수 획득
						ground[3]=false;
					}
					for(int k=2; k>0; k--) {
						ground[k+1]=ground[k]; //1루씩 진출
						ground[k]=false;
					}
					
					ground[1]=true; //1루에 현재 선수가 진출
					break;
					
				case 2: //2루타 - 2루씩 진출
					for(int k=3; k>1; k--) { //3루, 2루에 선수가 있을 경우, 점수 획득
						if(ground[k]) {
							score++;
						}
						ground[k]=false;
					}
					
					if(ground[1]) { //1루에 선수가 있었다면 3루로
						ground[3]=true;
					}
					ground[1]=false; //1루는 비어있어야 함
					
					ground[2]=true; //현재 타자는 2루로
					break;
					
				case 3: //3루타 - 세 루씩 진루
					for(int k=3; k>0; k--) { //3,2,1루에 사람이 있을 경우, 점수 획득
						if(ground[k]) {
							score++;
						}
						ground[k]=false;
					}
					ground[3]=true; //현재 타자는 3루로
					break;
					
				case 4: //홈런
					for(int k=3; k>0; k--) {
						if(ground[k]) {
							score++;
						}
						ground[k]=false;
					}
					score++; //타자가 들어옴
					break;
					
				case 0: //아웃일 경우
					outCnt++;
					break;
				}
			}
			
			//한 이닝이 끝났을 경우
			outCnt=0;
			++inning;
			Arrays.fill(ground, false);
		}
		
		ans=Math.max(ans, score);
	}

}
