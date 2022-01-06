package com.algo2022.Jan.day0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int A,B,max,min,gcd,lcm;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			max = Math.max(A, B);
			min = Math.min(A, B);
			
			gcd = gcd(max,min);
			lcm = (A*B)/gcd;
			
			System.out.println(lcm);
		}
		
	}

	private static int gcd(int max, int min) {
		
		while(min!=0) {
			int r = max%min;
			max=min;
			min=r;
		}
		
		return max;
	}

}
