package com.ssafy.Mar.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_17103_골드바흐파티션 {

	static int T;
	static boolean[] isPrim;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		int MAX = Integer.MIN_VALUE;
		int[] arr = new int[T];
		for(int i=0; i<T; i++) {
			arr[i]=sc.nextInt();
			if(MAX<arr[i]) MAX=arr[i];
		}
		
		isPrim = new boolean[MAX+1];
		//Arrays.fill(isPrim, true);
		getPrim(MAX);

		for(int i=0; i<T; i++) {
			int count=0;
			int num = arr[i];

			for(int j=2; j<=num/2; j++) {
				if(isPrim[j]) continue;
				
				if(!isPrim[num-j]) count++;
			}
			System.out.println(count);
		}
	}

	/*
	 * 소수 구하기 : 에라토스테네스의 접근
	 * 주어진 자연수 N이 소수이기 위한 필요충분 조건은 N이 N의 제곱근보다 크지 않은 어떤 소수로도 나눠지지 않는다
	 */
	private static void getPrim(int max) {
		isPrim[1]=true;
		outer: for(int i=2; i<=max; i++) {
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(j!=1 && i%j == 0) {
					isPrim[i]=true;
					continue outer;
				}
			}
		}
	}

}
