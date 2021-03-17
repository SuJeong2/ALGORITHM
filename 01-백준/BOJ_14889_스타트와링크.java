package com.ssafy.Mar.day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

	static int N, C;
	static int[][] synergy;
	static int[] numbers;
	static int[] numbers2;
	static int min;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N=Integer.parseInt(st.nextToken());
		C=N/2;
		
		synergy = new int[N][N];
		numbers = new int[C];
		numbers2 = new int[C];
		selected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=0; j<N; j++) {
				synergy[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		min=Integer.MAX_VALUE;
		comb(0,0);
		
		//결과
		System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		if(cnt==C) {

			int index=0;
			for(int i=0; i<N; i++) {
				if(!selected[i]) numbers2[index++]=i;
			}
	
			int teamStart=0;
			int teamLink=0;
			
			for(int i=0; i<C; i++) {
				for(int j=i+1; j<C;j++) {
					teamStart+=synergy[numbers[i]][numbers[j]];
					teamStart+=synergy[numbers[j]][numbers[i]];
					
				}
			}
			for(int i=0; i<C; i++) {
				for(int j=i+1; j<C;j++) {
					teamLink+=synergy[numbers2[i]][numbers2[j]];
					teamLink+=synergy[numbers2[j]][numbers2[i]];
				}
			}
			
			min=Math.min(min, Math.abs(teamStart-teamLink));
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt]=i;
			selected[i]=true;
			comb(cnt+1, i+1);
			selected[i]=false;
		}
		
	}

	
}
