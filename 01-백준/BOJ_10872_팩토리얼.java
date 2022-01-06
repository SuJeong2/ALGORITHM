package com.algo2022.Jan.day0106;

import java.util.Scanner;

public class BOJ_10872_팩토리얼 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 1;
		for(int i=2; i<=N; i++) {
			result *= i;
		}
		System.out.println(result);
	}

}
