package com.ssafy.Mar.day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		
		st = new StringTokenizer(rb.readLine());
		for(int i=0;i<N; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		for(int i=1; i<N; i++) {
			numbers[i]+=numbers[i-1];
		}
		
		int sum=0;
		for(int i=0; i<N; i++) sum+=numbers[i];
		
		System.out.println(sum);
	}

}
