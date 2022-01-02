package com.algo2022.Jan.day0102;

import java.util.Scanner;

public class BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		while(min!=0) {
			int mod = max%min;
			max=min;
			min=mod;
		}
		
		int gcd = max;
		int lcm = (a*b)/gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}

}
