package com.ssafy.May.day0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	
	static int N, T[], P[], profit[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		profit = new int[N]; //최대 이익을 저장하는 배열
		
		for(int i=0; i<N; i++) {
			st =new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		getMaxProfit();
		Arrays.sort(profit); //오름차순 정렬
		System.out.println(profit[N-1]);
	}
 
	/*
			1		2		3		4		5		6		7		8		9		10
	T		5		4		3		2		1		1		2		3		4		5
	P		50		40		30		20		10		10		20		30		40		50
	
	profit	50+40	40+40	30+40	20+40	10+40	10+30	20+0	30		0		0
	 */
	private static void getMaxProfit() {
		//뒤에서부터 이익을 계산
		for(int i=N-1; i>=0; i--) {
			if((i-1)+T[i]>=N) { //현재 날 + 상담일수가 N을 넘어가는 경우
				profit[i]=0;
				continue;
			}
			
			//i일에 상담을 T[i]일만큼 하고 그 이후에 날이 남아 있을 경우
			if(i+T[i]<N) {
				int max=0;
				/*
				 * i+T[i]일 이후에 상담 최대 이익을 구함
				 */
				for(int k=i+T[i]; k<N; k++) {
					max=Math.max(max, profit[k]);
				}
				
				profit[i]=P[i]+max; //i일 상담 + (i+T[i])일 이후의 상담 최대이익
			}
			else
				profit[i]=P[i]; //이 날 이익이 최대 이익이 됨
		}
		
	}
}
