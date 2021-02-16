package com.ssafy.day0215;

import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이 {

	static int[] nanjang, numbers;
	static boolean flag;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		nanjang = new int[9];
		numbers = new int[9];
		
		for(int i=0; i<9; i++) {
			nanjang[i] = sc.nextInt();
		}
		
		flag = true;
		comb(0,0);
		
		for(int i=0; i<7; i++)
			System.out.println(nanjang[numbers[i]]);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==7) {
			int sum=0;
			for(int i=0; i<7; i++) {
				sum+=nanjang[numbers[i]];
			}
			
			if(sum==100) {
				flag = false;
				return;
			}
			
			return;
		}
		
		for(int i=start; i<9; i++) {
			numbers[cnt]=i;
			comb(cnt+1, i+1);
			
			if(flag==false)
				break;
		}
	}

}
