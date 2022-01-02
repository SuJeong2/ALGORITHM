package com.algo2022.Jan.day0102;

import java.util.Scanner;

public class BOJ_10870_피보나치수5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[22];
		
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2; i<=n; i++) {
			arr[i]=arr[i-2]+arr[i-1];
		}
		
		System.out.println(arr[n]);
	}

}
