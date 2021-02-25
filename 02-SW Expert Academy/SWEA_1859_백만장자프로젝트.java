package com.ssafy.day0222;

import java.util.Scanner;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int N;
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i]=sc.nextInt();
			}
			
			//뒤에서부터 계산
			int max = arr[N-1];
			long ans=0; //자료형 범위 때문에 long으로 변수 선언해야 함
			for(int i=N-2; i>=0; i--) {
				if(arr[i]>max) {
					max=arr[i];
					continue;
				}
				ans+=(max-arr[i]);
			}
			
			System.out.println("#"+tc+" "+ans);
		}

	}

}
