package com.ssafy.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int grade, gender;
		int[][] info = new int[7][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			//여학생 0, 남학생 1
			gender = Integer.parseInt(st.nextToken());
			grade = Integer.parseInt(st.nextToken());
			
			info[grade][gender]++;
		}
		
		int count=0;
		for(int i=1; i<=6; i++) {
			for(int j=0; j<2; j++) {
				if(info[i][j]==0) continue;
				
				if(info[i][j]%K == 0) {
					count+=(info[i][j]/K);
				}
				if(info[i][j]%K != 0) {
					count+=(info[i][j]/K);
					count+=1;
				}
				
			}
		}
		
		System.out.println(count);
	}
}
