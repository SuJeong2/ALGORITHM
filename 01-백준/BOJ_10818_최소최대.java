package com.algo2022.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10818_최소최대 {

	public static void main(String[] args) throws IOException {
		
		//1. Scanner + Array 정렬
		/*
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);

		System.out.println(arr[0]+" "+arr[N-1]);
		*/
		
		//2. BufferedReader + 한 값씩 비교하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int max=Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a<min) min=a;
			if(a>max) max=a;
		}
		
		System.out.println(min+" "+max);
	}

}
