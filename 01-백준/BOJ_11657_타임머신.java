package com.ssafy.Jun.day0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Bellman-ford
 * 벨만포드
 * 
 * 음의 가중치가 있을 때, 최단 경로 구하기
 */
public class BOJ_11657_타임머신 {

	static class Bus{
		int from, to, weight;

		public Bus(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		
		long[] distance = new long[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1]=0;
		
		Bus[] bus = new Bus[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			bus[i] = new Bus(from, to, weight);
		}
		
		boolean flag = false;
		//모든 정점에 대해 간선의 수만큼 비교하며 갱신
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				Bus curBus = bus[j];
				
				//from번 노드까지 오는 경우의 수가 있을 때 && 현재 to번까지 오는 값 > 현재 from번까지의 오는 값 + from에서 to로 가는 비용
				if(distance[curBus.from]!=Integer.MAX_VALUE && distance[curBus.to] > distance[curBus.from]+curBus.weight) {
					distance[curBus.to] = distance[curBus.from]+curBus.weight; //갱신
					
					if(i==N) { //싸이클이 발생하는 경우 - N번째 순회에서 완화가 되는 경우
						flag=true;
					}
				}
				
			}
		}
		
		if(flag) { //싸이클 발생
			System.out.println(-1);
		}
		else { //아닐 경우 2번 도시부터 출력 (갈 수 없는 곳일 경우 MAX_VALUE 값을 가짐 -> -1 출력)
			for(int i=2; i<=N; i++) {
				System.out.println(distance[i]==Integer.MAX_VALUE? -1 : distance[i]);
			}
		}
		
	}

}
