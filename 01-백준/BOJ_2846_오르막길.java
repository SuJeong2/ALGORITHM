package com.ssafy.May.day0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846_오르막길 {

	static int N, arr[], max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		max=0;
		getMax();
		
		//결과
		System.out.println(max);
	}

	private static void getMax() {
		
		int sum=0;
		for(int i=1; i<N; i++) {
			
			if(arr[i-1]<arr[i]) {
				//오르막길인 경우
				sum+= (arr[i]-arr[i-1]);
			}
			
			else {
				//내리막길이거나 평지일 경우
				max= Math.max(sum, max);
				sum=0;
			}
			
			if(i==N-1) { //가장 마지막 값일 경우에는, 계산줘야 함
				max= Math.max(sum, max);
			}
		}
	}

}
