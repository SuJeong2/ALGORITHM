package com.ssafy.day0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {

	static int R,C;
	static char[][] board;
	static int count, MAX = Integer.MIN_VALUE;
	static int[][] dir = {{0,-1}, {-1,0},{0,1},{1,0}};
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		selected = new boolean[26];
		
		for(int i=0; i<R; i++) {
			board[i]=rb.readLine().toCharArray();
		}
		
		//System.out.println(Arrays.deepToString(board));
		count=0;
		getMaxRoad(0,0);
		
		System.out.println(MAX);
	}

	
	public static void getMaxRoad(int r, int c) {
		
		if(selected[board[r][c]-'A']==true) {
			
			MAX = Math.max(MAX, count);
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			if(r+dir[i][0]<0 || r+dir[i][0]>=R || c+dir[i][1]<0 || c+dir[i][1]>=C)
				continue;

			selected[board[r][c]-'A']=true;
			count++;
			getMaxRoad(r+dir[i][0], c+dir[i][1]);

			selected[board[r][c]-'A']=false;
			count--;
		}
		
	}
}
