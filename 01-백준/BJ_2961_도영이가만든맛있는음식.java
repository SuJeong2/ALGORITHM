package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식 {

	static int T;
	static int[][] ingre;
	static int MIN = Integer.MAX_VALUE;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		ingre = new int[T][2];
		isSelected = new boolean[T];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(rb.readLine());
			ingre[i][0]=Integer.parseInt(st.nextToken());
			ingre[i][1]=Integer.parseInt(st.nextToken());
		}

		subset(0);
		
		System.out.println(MIN);
	}

	public static void subset(int cnt) {
		if(cnt == T) {
			int score=0;
			boolean flag=false;
			int s=1, b=0;
			for(int i=0; i<T; i++) {
				if(isSelected[i]) {
					s*=ingre[i][0];
					b+=ingre[i][1];
					flag=true;
				}
			}
			score = Math.abs(s-b);
			if(flag) {
				MIN = Math.min(score, MIN);
			}
			return;
		}
		
		isSelected[cnt]=true;
		subset(cnt+1);
		
		isSelected[cnt]=false;
		subset(cnt+1);
	}
}
