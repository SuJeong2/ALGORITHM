package com.ssafy.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2116_주사위쌓기 {

	static int N;
	static int[][] dice;
	static int[] bottom, up;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		N=Integer.parseInt(st.nextToken());
		dice = new int[N][6];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=0; j<6; j++) {
				dice[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bottom = new int[N];
		up = new int[N];
		
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<6; i++) {
			getBottomUp(i);
			
			int sum=0;
			for(int j=0; j<N; j++) {
				int Max = Integer.MIN_VALUE;
				for(int k=0; k<6; k++) {
					if(k==up[j] || k==bottom[j]) continue;
					
					Max = Math.max(Max, dice[j][k]);
				}
				sum+=Max;
			}
			//System.out.println("Bottom "+Arrays.toString(bottom));
			//System.out.println("Up "+Arrays.toString(up));
			ans = Math.max(ans, sum);
			//System.out.println(ans);
		}

		System.out.println(ans);
	}

	public static void getBottomUp(int num) {
		bottom[0] = num;
		for(int i=1; i<N; i++) {
			//위쪽 부분 수 찾기
			up[i-1]=getIndex(bottom[i-1]);
			
			//다음 주사위의 아래부분 수 찾기
			//위쪽 수랑 같은 숫자를 가진 면의 인덱스 값을 찾아야 함
			int number = dice[i-1][up[i-1]];
			for(int j=0; j<6; j++) {
				if(dice[i][j]==number) {
					bottom[i]=j;
				}
			}
		}
		
		up[N-1]=getIndex(bottom[N-1]);
	}
	
	public static int getIndex(int index) {
		int result=0;
		switch(index) {
		case 0:
			result=5;
			break;
		case 1:
			result=3;
			break;
		case 2:
			result=4;
			break;
		case 3:
			result=1;
			break;
		case 4:
			result=2;
			break;
		case 5:
			result=0;
			break;
		}
		
		return result;
	}
}
