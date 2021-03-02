package com.ssafy.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_11545_틱택톡 {

	static char[][] game;
	static int Ocnt=0, Xcnt=0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		boolean flag=false;
		game = new char[4][4];
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<=T; tc++) {
			Ocnt=0; Xcnt=0; //O와 X의 카운트 값 초기화
			flag=true; //flag값도 초기화
			
			for(int i=0; i<4; i++) {
				String line = rb.readLine();
				for(int j=0; j<4; j++)
					game[i][j]= line.charAt(j);
			}
			//System.out.println(Arrays.deepToString(game));
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(game[i][j]=='.') {
						flag=false;
						continue;
					}
					if(game[i][j]=='T')
						continue;

					if(getResult(i,j)) {
						if(game[i][j]=='O') Ocnt++;
						else Xcnt++;
					}
				}
			}

			System.out.print("#"+tc+" ");
			if(Ocnt==Xcnt) {
				if(!flag) System.out.println("Game has not completed");
				else System.out.println("Draw");
			}
			else {
				if(Ocnt==Xcnt) System.out.println("Draw");
				else System.out.println( Ocnt>Xcnt? "O won" : "X won" );
			}

			rb.readLine(); //tc마다 줄 바꿈 처리
		}

	}
	
	public static boolean getResult(int r, int c) {
		//가로 체크
		int rowCount=0;
		for(int i=0;i<4; i++) {
			if(game[r][i]==game[r][c] || game[r][i]=='T')
				rowCount++;
		}
		if(rowCount==4) return true;
		
		//세로체크
		int colCount=0;
		for(int i=0;i<4; i++) {
			if(game[i][c]==game[r][c] || game[i][c]=='T')
				colCount++;
		}
		if(colCount==4) return true;
		
		//대각선체크 안해도 되는 경우
		if(r<1||r>2 || c<1||c>2) return false;
		
		//대각선 체크
		int cnt=0;
		for(int i=0;i<4; i++) {
			if(game[i][i]==game[r][c] || 'T'==game[i][i])
				cnt++;
		}
		if(cnt==4) return true;
		
		cnt=0;
		for(int i=0, j=3; i<4; i++, j--) {
			if(game[i][j]==game[r][c] || 'T'==game[i][j])
				cnt++;
		}
		if(cnt==4) return true;
		
		return false;
	}

}
