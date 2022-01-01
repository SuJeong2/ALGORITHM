package com.algo2022.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2460_지능형기차2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max=0, out=0, in=0, people=0;
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			out = Integer.parseInt(st.nextToken());
			in = Integer.parseInt(st.nextToken());
			
			people -= out;
			people += in;
			
			max = Math.max(max, people);
		}
		
		System.out.println(max);

	}

}
