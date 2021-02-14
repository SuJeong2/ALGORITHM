package com.ssafy.day0214;

import java.util.Scanner;

public class Subset {

	static int[] arr;
	static int N, totalCnt=0;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0;i<N; i++)
			arr[i]=sc.nextInt();

		System.out.println("==Subset 부분집합==");
		Subset(0);
		System.out.println("부분집합 개수 : "+totalCnt);
	}

	public static void Subset(int cnt) {
		
		if(cnt==N) {
			totalCnt++;
			for(int i=0; i<N; i++) {
				System.out.print( (isSelected[i] ? arr[i] : "X")+"\t" );
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt]=true;
		Subset(cnt+1);
		
		isSelected[cnt]=false;
		Subset(cnt+1);
	}
}
