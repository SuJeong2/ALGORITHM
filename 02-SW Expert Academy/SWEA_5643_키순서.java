package com.ssafy.Apr.day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

	static int ans,N,M,a,b;
	static ArrayList<ArrayList<Integer>> graph, reverse;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			ans=0;
			
			N=Integer.parseInt(br.readLine()); //학생수
			M=Integer.parseInt(br.readLine()); //비교한 횟수
			
			graph = new ArrayList<>();
			reverse = new ArrayList<>();
			
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
				reverse.add(new ArrayList<>());
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				a=Integer.parseInt(st.nextToken());				
				b=Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				reverse.get(b).add(a);
			}
			
			getStudent();
			
			//결과
			System.out.println("#"+tc+" "+ans);
		}

	}

	private static void getStudent() {

		for(int i=1; i<=N; i++) {
			int count=0;
			
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N+1]; 
			queue.offer(i);
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				count++;
				
				
				
				for(int k=0; k<graph.get(cur).size(); k++) {
					int temp = graph.get(cur).get(k);
					if(!visited[temp]) {
						visited[temp]=true;
						queue.offer(temp);
					}
				}
			}
			
			queue.clear();
			
			boolean[] visited2 = new boolean[N+1]; 
			queue.offer(i);
			
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				count++;
				for(int k=0; k<reverse.get(cur).size(); k++) {
					int temp = reverse.get(cur).get(k);
					if(!visited2[temp]) {
						visited2[temp]=true;
						queue.offer(temp);
					}
				}
			}
			
			if(count-1==N) {
				ans++;
			}
			
		}
		
	}

}
