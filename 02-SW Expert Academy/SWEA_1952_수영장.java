package com.ssafy.Mar.day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int[] price = new int[4];
		int[] month = new int[13];
		
		for(int tc=1; tc<=T; tc++) {
			
			//이용권 가격
			st = new StringTokenizer(rb.readLine());
			for(int i=0; i<4; i++) {
				price[i]=Integer.parseInt(st.nextToken());
			}
			
			//매달 사용 일수
			st = new StringTokenizer(rb.readLine());
			for(int i=1; i<=12; i++) {
				month[i]=Integer.parseInt(st.nextToken());
			}
			
			//1월
			month[1]=Math.min(month[1]*price[0], price[1]);
			//2월
			month[2]=Math.min(month[2]*price[0], price[1]);
			
			//3월-12월
			for(int i=3; i<=12; i++) {
				int d = month[i]*price[0];
				int m = price[1];
				int m3 = price[2]-month[i-1]-month[i-2];
				
				month[i]=Math.min(d, m);
				month[i]=Math.min(month[i], m3);
			}
			
			int sum=0;
			for(int i=1; i<=12; i++) {
				sum+=month[i];
			}
			
			sum=Math.min(sum, price[3]);
			
			//결과
			System.out.println("#"+tc+" "+sum);
		}

	}

}
