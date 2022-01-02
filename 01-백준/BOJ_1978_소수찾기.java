package com.algo2022.Jan.day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int count=0;
		boolean flag=false;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			flag = false;
			int num = Integer.parseInt(st.nextToken());
			
			if(num==1) continue;
			
			for(int j=2; j<num && !flag; j++) {
				if(num%j==0) {
					flag = true;
				}
			}
			
			if(!flag) count++;
		}
		
		System.out.println(count);
		
	}

}
