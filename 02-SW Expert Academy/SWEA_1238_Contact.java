package com.ssafy.Mar.day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(rb.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(rb.readLine());
			int from=0, to=0;
			ArrayList[] list = new ArrayList[101];
			for(int i=0; i<len/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				if(list[from]==null) {
					list[from] = new ArrayList<Integer>();
					list[from].add(to);
				}
				else {
					list[from].add(to);
				}
			}
			
//			for(int i=0; i<list.length;i++) {
//				if(list[i]==null) continue;
//				System.out.print(i +" : ");
//				for(int j=0; j<list[i].size();j++) {
//					System.out.print(list[i].get(j)+" ");
//				}
//				System.out.println();
//			}
			
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean[] visited = new boolean[101];
			
			int depth=0, max=0;	
			queue.offer(new int[] {start, 0});
			visited[start]=true;
			
			while(!queue.isEmpty()) {
				int[] current = queue.poll();
				//System.out.println("depth : " + depth + " "+current[0] + " "+current[1]);
				
				if(current[1]>depth) {
					max=current[0];
					depth=current[1];
				}
				if(current[1]==depth) {
					max=Math.max(max, current[0]);
				}
				
				if(list[current[0]]==null) continue; //인접한 노드가 없을 경우
				
				for(int i=0; i<list[current[0]].size(); i++) {
					int adj = (int) list[current[0]].get(i);
					
					
					if(visited[adj]) continue;
					
					visited[adj]=true;
					queue.offer(new int[] {adj, current[1]+1});
				}
			}
			
			//결과
			System.out.println("#"+tc+" "+max);
		}
		
	}
}
