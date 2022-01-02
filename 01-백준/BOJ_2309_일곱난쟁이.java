package com.algo2022.Jan.day0102;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {

	static int[] numbers, arr;
	static boolean flag;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		numbers = new int[7];
		
		for(int i=0; i<9; i++) {
			arr[i]=sc.nextInt();
		}
		
		Comb(0,0);
	}

	private static void Comb(int cnt, int start) {

		if(cnt==7) {
			int sum = Arrays.stream(numbers).sum();
			if(sum==100) {
				flag=true;
				Arrays.sort(numbers);
				for(int i=0; i<7; i++)
					System.out.println(numbers[i]);
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			numbers[cnt]=arr[i];
			Comb(cnt+1, i+1);
			if(flag) return;
		}
	}

}
