package com.ssafy.day0214;

import java.util.Scanner;

public class Combination {

	static int[] arr, numbers;
	static int N,R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		R=sc.nextInt();
		
		arr = new int[N];
		numbers = new int[N];
		
		for(int i=0;i<N; i++)
			arr[i]=sc.nextInt();

		System.out.println("==Combination 조합==");
		Combination(0,0);
	}

	public static void Combination(int cnt, int start) {
		if(cnt==R) {
			for(int i=0; i<R; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt]=arr[i];
			Combination(cnt+1, i+1);
		}
	}
}
