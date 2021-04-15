package com.ssafy.Apr.day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	
	static int min, N, selectedCnt;
	static int[] people,team1, team2;
	static boolean[] selected, visited;
	static ArrayList<Integer> region[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		//인구수
		people=new int[N];
		for(int i=0; i<N; i++) {
			people[i]= Integer.parseInt(st.nextToken());
		}
		
		region = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			region[i] = new ArrayList<Integer>();
		}
		
		//인접한 구역 정보 저장
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				region[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		min = Integer.MAX_VALUE;
		
		//선거구를 1개,2개 ,,, (N/2)개 선택
		/*
		 A 그룹 	B 그룹
		 1개 선택	N-1개 선택
		 2개 선택	N-2개 선택
		 ....
		 N-1개 선택	1개 선택
		 
		 결국 1개 선택 ... N/2개 선택까지 해서 구역을 나누면 됨
		*/
		
		for(int i=1; i<=N/2; i++) {
			team1=new int[i]; //조합을 통해 선택할 구역
			team2 = new int[N-i]; // 선택되지 않은 구역
			selected = new boolean[N+1];
			makeTeam(0, 1, i);
		}
		
		if(min == Integer.MAX_VALUE) //두 선거구로 나눌 수 없는 경우
			System.out.println(-1);
		else System.out.println(min);
	}

	private static void makeTeam(int cnt, int start, int size) {
		
		if(cnt==size) { //만들려했던 사이즈만큼 선택이 되었다면(조합이 만들어졌다면)
			selectedCnt=0; //전체 지역 중 선택된 지역의 개수를 구할 변수
			gerrymandering(size);
			return;
		}
		for(int i=start; i<=N; i++) {
			if(selected[i]) continue;
			
			team1[cnt]=i; //선택된 구역의 번호를 저장
			selected[i]=true; //선택된 구역 선택 처리
			makeTeam(cnt+1,i+1, size);
			selected[i]=false;
		}
	}

	private static void gerrymandering(int size) {
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(!selected[i]) { //선택되지 않는 구역인 경우
				team2[cnt++]=i; //조합에서 선택되지 않은 다른 구역을 만든다
			}
		}
		
		//나눠진 구역 2개가 각각 연결되어 있는지 확인하기
		if(checkConnection(team1, true) && checkConnection(team2, false)) {
			if(selectedCnt==N) { 
				//2개의 구역에서 연결된 구역의 개수가 총 N개이면 -> 2개의 선거구로 나눌 수 있다
				//N이 아니라면 2개의 선거구로 나눌 수 없다(3개 이상으로 나눠짐)
				
				//각각 2개의 구역이 다 연결되어 있으면서
				// 전체가 선택되었을 경우
				//각 구역의 인원수를 구하고 최솟값 갱신
				int people1=0;
				for(int i=0; i<team1.length; i++) {
					people1+=people[team1[i]-1];
				}
				int people2=0;
				for(int i=0; i<team2.length; i++) {
					people2+=people[team2[i]-1];
				}
				
				//최솟값 갱신
				min = Math.min(min, Math.abs(people1-people2));
			}
		}
		
		
	}

	//team1, team2가 다 연결되어 있는지 체크
	//team2일 경우 - 조합으로 선택되지 않은 지역 - flag값은 false
	private static boolean checkConnection(int[] team, boolean flag) {
		
		visited = new boolean[N+1]; //그래프 순회에서 방문처리할 배열
		if(!flag) {
			Arrays.fill(visited, !flag); //만약 flag가 flase이면 true로 바꿈
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(team[0]);
		visited[team[0]]=flag;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=0; i<region[cur].size(); i++) {
				
				int temp =region[cur].get(i);
				if(visited[temp]!=flag && selected[temp]==flag) {
					//방문하지 않았고, 선택된 구역 번호일 때만
					visited[temp]=flag;
					queue.offer(temp);
				}
					
			}
		}
		
		//1부터 N번까지 돌면서 selected값과 visited 처리된 값을 비교해서
		//다 같을 경우 -> 그 구역의 지역들은 다 연결되어 있다.
		for(int i=1; i<=N; i++) {
			if(selected[i]!=visited[i]) return false; //연결되어 있지 않을 경우
			if(visited[i]==flag) selectedCnt++;
		}
		
		return true; //다 연결되어 있는 경우
	}
	
	
}
