package com.ssafy.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1037_오류교정 {

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		//입력 값 처리
		N=Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		/**
		 * cnt는 오류가 발생하는 행/열의 개수 카운트
		 * ansI는 바꿔야 하는 행의 번호
		 * ansJ는 바꿔야 하는 열의 번호
		 */
		int cnt=0, ansI=-1, ansJ=-1;
		boolean flag = true; //중간에 오류 발생시 false로 변환
		for(int i=0; i<N; i++) {
			int sum = Arrays.stream(map[i]).sum();
			if(sum%2==0) continue;
			
			cnt++;//오류가 생긴 행의 개수 카운트
			ansI=i; //바꿔야 하는 행의 번호 저장
			flag = false; //OK가 될 수 없다
		}
		
		if(cnt>=2) //만약 바꿔야 하는 행의 개수가 2개 이상이라면 이미 교정할 수 없는 케이스가 됨
			System.out.println("Corrupt");
		else {
			cnt=0; //바꿔야 하는 열의 개수를 카운트하기 위해 변수 초기화
			for(int i=0; i<N; i++) {
				int sum=0;
				for(int j=0; j<N; j++) {
					sum+=map[j][i]; //열의 합을 구함
				}
				
				if(sum%2==0) continue;
				
				//열에 오류가 발생했을 때,
				ansJ=i; //바꿔야 하는 열의 번호 저장
				cnt++; //오류가 생긴 열의 개수 증가
				flag=false; //OK가 될 수 없다
			}
			
			if(flag) System.out.println("OK");
			else if (!flag && cnt>=2) System.out.println("Corrupt"); //바꿔야 하는 열의 개수도 2개 이상이 되었다면 corrupt
			else System.out.println("Change bit ("+(ansI+1)+","+(ansJ+1)+")");
		}
		
	}
}
