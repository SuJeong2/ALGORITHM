package com.ssafy.Jun.day0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2616_소형기관차 {

	public static void main(String[] args) throws IOException {
		int N, max;
		int people[], sum[], dp[][];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		people = new int[N];
		sum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				sum[0]=people[0];
				continue;
			}
			sum[i] = people[i]+sum[i-1];
		}
		System.out.println(Arrays.toString(sum));
		st = new StringTokenizer(br.readLine());
		max = Integer.parseInt(st.nextToken());
		
		dp = new int[max+1][N];
		
		for(int i=1; i<max+2; i++) {
			for(int j=i*max; j<N; j++) {
				dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j-max]+(sum[j]-sum[j-max]));
			}
		}
		
//		for(int i=0; i<N; i++) {
//			if(i==0) continue;
//			dp[0][i] = people[i]+people[i-1];
//		}
//		for(int i=1; i<max+1; i++) {
//			for(int j=i*max+1; j<N; j++) {
//				dp[i][j]=Math.max(dp[i][j-1], dp[0][j]+dp[i-1][j-max]);
//			}
//		}

		System.out.println(dp[max+1][N-1]);
	}

}
