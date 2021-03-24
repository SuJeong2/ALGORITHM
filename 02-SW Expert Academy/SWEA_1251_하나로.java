package com.ssafy.Mar.day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Node {
	int n1, n2;
	double edge;

	public Node(int n1, int n2, double edge) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.edge = edge;
	}
}


public class SWEA_1251_하나로 {

	static ArrayList<Node> list;
	static int N;
	
	static int parents[];
	static void make() { //크기가 1인 단위집합을 만든다.
		for(int i=0; i<N; i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		//return findSet(parents[a]); //path compression 전
		return parents[a]=findSet(parents[a]); //path compression 후
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		//같은 조직일 떄,
		if(aRoot==bRoot) return false;
		
		//조직이 서로 다를 때,
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(rb.readLine());
			N = Integer.parseInt(st.nextToken());

			int[] x = new int[N];
			int[] y = new int[N];

			// x값 받기
			st = new StringTokenizer(rb.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			// y값 받기
			st = new StringTokenizer(rb.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(rb.readLine());
			double E = Double.parseDouble(st.nextToken());

			double val = 0.0;
			list = new ArrayList<Node>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					val=0;
					val = Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);
					val = Math.pow(Math.sqrt(val), 2) * E;
					//val = val * E;
					list.add(new Node(i, j, val));
				}
			}

			Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2){
                	 return Double.compare(o1.edge, o2.edge);
                }
            });
			
			parents = new int[N];
			make();
			
			int cnt=0;
			double sum=0.0;
			int index=0;
			while(cnt<N-1) {
				
				if(union(list.get(index).n1, list.get(index).n2)) {
					sum+=list.get(index).edge;
					cnt++;
				}

				index++;
			}

			// 결과
			//System.out.println("#" + tc + " "+(int)sum);
			System.out.format("#%d %.0f\n", tc, sum);
		}

	}

}
