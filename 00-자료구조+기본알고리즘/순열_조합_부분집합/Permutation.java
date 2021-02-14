package com.ssafy.day0214;

import java.util.Scanner;

public class Permutation {

	static int[] arr, numbers;
	static int N,R;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		R=sc.nextInt();
		
		arr = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0;i<N; i++)
			arr[i]=sc.nextInt();

		System.out.println("==Permutation 순열==");
		permutation(0);
	}

	public static void permutation(int cnt) {
		if(cnt==R) {
			for(int i=0; i<R; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]==true) continue;
			
			isSelected[i]=true;
			numbers[cnt]=arr[i];
			
			permutation(cnt+1);
			
			isSelected[i]=false;			
		}
	}
}
