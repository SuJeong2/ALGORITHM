package com.ssafy.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {

	static int[] p1, p2, numbers;
	static boolean[] isSelected, isSelected2;
	static int win, lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(rb.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc<=T; tc++) {
			p1 = new int[9];			
			p2 = new int[9];
			numbers = new int[9];
			isSelected = new boolean[19];
			isSelected2 = new boolean[9];
			
			st = new StringTokenizer(rb.readLine());
			
			for(int i=0; i<9; i++) {
				p1[i]=Integer.parseInt(st.nextToken());
				isSelected[p1[i]]=true;
			}
			
			int cnt=0;
			for(int i=1; i<19; i++) {
				if(isSelected[i]==false)
					p2[cnt++]=i;
			}
			
			//System.out.println(Arrays.toString(p1));
			//System.out.println(Arrays.toString(p2));
			
			win=0;
			lose=0;
			permutation(0);
			
			System.out.println("#"+tc +" "+win+" "+lose);
		}
		
	}

	public static void permutation(int cnt) {
		if(cnt==9) {
			int p1_sum=0, p2_sum=0;
			for(int i=0; i<9; i++) {
				if(p1[i]>numbers[i]) p1_sum=p1_sum+p1[i]+numbers[i];
				else p2_sum = p2_sum+p1[i]+numbers[i];
			}
			
			if(p1_sum>p2_sum) win++;
			else lose++;
			
			return;
		}
		for(int i=0; i<9; i++) {
			if(isSelected2[i]==true) continue;
			
			isSelected2[i]=true;
			numbers[cnt]=p2[i];
			
			permutation(cnt+1);
			
			isSelected2[i]=false;
		}
	}

}
