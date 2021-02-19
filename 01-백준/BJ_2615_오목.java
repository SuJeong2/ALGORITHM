package com.ssafy.day0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2615_오목 {

	static int[][] Omok;
	static int N = 19;
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		Omok = new int[N+2][N+2];

		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(rb.readLine());
			for(int j=1; j<=N; j++)
				Omok[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[3];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				
				//오른쪽으로
				if(Omok[i][j]!=0 && Omok[i][j]==Omok[i][j+1]) {
					if(right(i,j)) {
						result[0] = Omok[i][j];
						result[1] = i;
						result[2] = j;
						break;
					}
				}
				
				if(Omok[i][j]!=0 && Omok[i][j]==Omok[i+1][j]) {
					if(down(i,j)) {
						result[0] = Omok[i][j];
						result[1] = i;
						result[2] = j;
						break;
					}
				}
				
				if(Omok[i][j]!=0 && Omok[i][j]==Omok[i-1][j+1]) {
					if(rightUp(i,j)) {
						result[0] = Omok[i][j];
						result[1] = i;
						result[2] = j;
						break;
					}
				}
				
				if(Omok[i][j]!=0 && Omok[i][j]==Omok[i+1][j+1]) {
					if(rightDown(i,j)) {
						result[0] = Omok[i][j];
						result[1] = i;
						result[2] = j;
						break;
					}
				}
				
			}
		}
		
		System.out.println(result[0]);
		if(result[0]!=0)
			System.out.println(result[1]+ " "+result[2]);
	}

	private static boolean right(int i, int j) {
		int cnt=1;
		if(Omok[i][j-1]==Omok[i][j]) return false;
		while(true) {
			if(Omok[i][j] == Omok[i][j+1])
				cnt++;
			else break;
			j++;
		}
		if(cnt==5) return true;
		else return false;
	}
	private static boolean down(int i, int j) {
		int cnt=1;
		if(Omok[i-1][j]==Omok[i][j]) return false;
		while(true) {
			if(Omok[i][j] == Omok[i+1][j])
				cnt++;
			else break;
			i++;
		}
		if(cnt==5) return true;
		else return false;
	}
	private static boolean rightUp(int i, int j) {
		int cnt=1;
		if(Omok[i+1][j-1]==Omok[i][j]) return false;
		while(true) {
			if(Omok[i][j] == Omok[i-1][j+1])
				cnt++;
			else break;
			i--; j++;
		}
		if(cnt==5) return true;
		else return false;
	}
	private static boolean rightDown(int i, int j) {
		int cnt=1;
		if(Omok[i-1][j-1]==Omok[i][j]) return false;
		while(true) {
			if(Omok[i][j] == Omok[i+1][j+1])
				cnt++;
			else break;
			i++; j++;
		}
		if(cnt==5) return true;
		else return false;
	}
}
