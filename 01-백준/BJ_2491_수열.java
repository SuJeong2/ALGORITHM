package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(rb.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		//결과값 출력을 위한 MAX변수
		int MAX = Integer.MIN_VALUE;
		
		//숫자가 커지는 방향 <=
		int count=1;
		for(int i=0; i<N-1; i++) {

			if(arr[i]<=arr[i+1]) {
				count++;
			}
			else {
				MAX=Math.max(MAX, count);
				count=1;
			}
		}
		//마지막까지 갔을 때, 구해진 값도 비교
		MAX=Math.max(MAX, count);
		
		count=1;
		//숫자가 작아지는 방향 >=
		for(int i=0; i<N-1; i++) {

			if(arr[i+1]<=arr[i]) {
				count++;
			}
			else {
				MAX=Math.max(MAX, count);
				count=1;
			}
		}
		//마지막까지 갔을 때, 구해진 값도 비교
		MAX=Math.max(MAX, count);
		
		System.out.println(MAX);	
	}
}
