package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2559_수열 {

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] temperature = new int[N];
		//ArrayList<Integer> list = new ArrayList<>(); //속도가 느려서 ArrayList를 써봤지만 더 느려짐
		
		st = new StringTokenizer(rb.readLine());
		for(int i=0; i<N; i++) {
			temperature[i]=Integer.parseInt(st.nextToken());
			//list.add(Integer.parseInt(st.nextToken()));
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<=N-K; i++) {
			int sum=0;
			for(int j=i; j<i+K; j++) {
				sum+=temperature[j];
				//sum+=list.get(j);
			}
			
			max=Math.max(sum, max);
		}
		
		System.out.println(max);
	}

}
