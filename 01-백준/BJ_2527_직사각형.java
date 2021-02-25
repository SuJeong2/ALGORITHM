package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] s1 = new int[4];
		int[] s2 = new int[4];
		for(int tc=1; tc<=4; tc++) {
			st= new StringTokenizer(rb.readLine());
			for(int i=0; i<4; i++)
				s1[i]=Integer.parseInt(st.nextToken());
			for(int j=0; j<4; j++)
				s2[j]=Integer.parseInt(st.nextToken());
			
			//공통부분이 없는 경우
			if(s2[2]<s1[0] || s1[2]<s2[0] || s2[3]<s1[1] || s1[3]<s2[1]) {
				System.out.println("d");
				continue;
			}
			
			if(s1[1]==s2[3] || s1[3]==s2[1]) {
				if(s1[2]==s2[0] || s1[0]==s2[2])
					System.out.println("c");
				else System.out.println("b");
				continue;
			}
			
			if(s1[2]==s2[0] || s1[0]==s2[2]) {
				if(s1[1]==s2[3] || s1[3]==s2[1])
					System.out.println("c");
				else System.out.println("b");
				continue;
			}
			
			System.out.println("a");
		}

	}

}
