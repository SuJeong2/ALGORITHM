package com.ssafy.Apr.day0406;

import java.util.Scanner;

public class BOJ_2858_기숙사바닥 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int B = sc.nextInt();
		
		/**
		 *  (L*2) + (W-2)*2 = R
		 *  2L + 2W -4 = R
		 *  L+W = (R+4)/2
		 *  
		 *  (W-2) * (L-2) = B
		 *  WL -2W -2L +4 = B
		 *  WL = B -4 + 2(W+L)
		 */
		int WplusL = (R+4)/2;
		int WL = B-4+2*WplusL;
		
		for(int i=1; i< WL/2; i++) {
			if(WL%i!=0) continue;
			
			//i * n이 WL이 될 수 있는 경우에만 비교 - n과 i를 곱해서 WL이 되는지
			int n = WL/i;
			if(n+i == WplusL) {
				//큰 수가 L => i가 1부터 시작하니깐 n이 큰 수가 됨
				System.out.println(n+" "+i);
				return;
			}
		}

	}

}
