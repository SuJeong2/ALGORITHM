package com.ssafy.day0304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {

	static boolean[] visited;
	static List<Integer> list[];
	static Queue<Integer> queue;
	
	/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //컴퓨터 개수
		visited = new boolean[N+1]; //방문처리 (1부터 시작)
		
		st = new StringTokenizer(rb.readLine()); //연결 선 개수
		int link = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1]; //각 컴퓨터마다 연결된 컴퓨터 번호를 저장
		for(int i=0; i<N+1; i++) {
			list[i]=new ArrayList<>();
		}
		
		int c1, c2;
		for(int i=0; i<link; i++) {
			st = new StringTokenizer(rb.readLine());
			c1= Integer.parseInt(st.nextToken());
			c2= Integer.parseInt(st.nextToken());
			
			//서로 연결되어 있다
			list[c1].add(c2);
			list[c2].add(c1);
		}
		
		queue = new LinkedList<>();
		queue.offer(1); //첫번째 컴퓨터
		BFS();

		int count=0;
		for(int i=2; i<=N; i++) { //1번 컴퓨터 제외하고 카운팅
			if(visited[i])
				count++;
		}
		
		System.out.println(count);
	}
	
	public static void BFS() {
		
		while(!queue.isEmpty()) {
			//큐의 맨 앞에 있는 것을 꺼낸다
			int i = queue.poll();
			
			//방문처리
			visited[i]=true;
			
			//해당 컴퓨터에 연결된 컴퓨터 방문체크 + 방문 안했으면 큐에 추가
			for(int k =0; k<list[i].size(); k++) {
				//이미 방문한 컴퓨터는 추가하지 않음
				//if(visited[list[i].get(k)]) continue;
				
				//큐에 추가
				queue.offer(list[i].get(k));
			}
		}
		
	}

}