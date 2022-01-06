package com.algo2022.Jan.day0106;

import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count=0;
		while(N>=5) {
			count+=N/5;
			N = N/5;
		}
		
		System.out.println(count);
		
	}

}
