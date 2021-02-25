package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_2578_빙고 {
	
	static int[][] bingo;
	static boolean[][] check;
	/*
	 * dr dc [0] - 왼쪽(9시방향) / [1]-오른쪽(3시방향)
	 * 		 [2] - 위(12시방향) / [3] - 아래(6시방향)
	 * 		 [4] - 11시 방향 / [5] - 5시방향
	 * 		 [6] - 7시 방향 / [7] - 1시 방향
	 */
	static int[] dr = {0,0,-1,1,-1,1,1,-1};
	static int[] dc = {-1,1,0,0,-1,1,-1,1};
	static int cnt=0;
	
	public static void main(String[] args) throws IOException {

		bingo = new int[5][5];
		check = new boolean[5][5];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++)
				bingo[i][j]=sc.nextInt();
		}
		
		int number=0;
		int[] loc, arr;
		
		//사회자가 부르는 숫자를 저장
		arr = new int[25];
		for(int i=0; i<25; i++) {
			arr[i] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(arr));
		
		//사회자가 부르는 값 순서대로 체크
		for(int i=0; i<25; i++) {
			loc=getLoc(arr[i]);
			check[loc[0]][loc[1]] = true; //불린 숫자는 true로
			
			getBingo(loc);

			if(cnt==3) {
				System.out.println(i+1); //몇 번째 수인지 출력하는 것이기 때문에 i+1
				break;
			}
		}
	}

	/**
	 * 해당 위치에서부터 팔방으로 탐색하여 빙고가 될 수 있는지 체크
	 * 탐색하는 값이 true이면 체크된 칸이므로 -> 계속 탐색
	 * 자기를 포함하여 count값이 5가 되면 빙고 -> cnt값 증가
	 * cnt가 3이 되면 게임 종료 -> return 해서 결과 출력
	 * 다른 방향으로도 확인해보기 위해서 for문을 끝날 때까지 돈다.
	 * @param loc
	 */
	private static void getBingo(int[] loc) {
		int count=1, newR, newC;
		for(int i=0; i<8; i++) {
			
			newR = loc[0]+dr[i];
			newC = loc[1]+dc[i];
			while(true) {
				//범위체크
				if(newR<0 || newR>=5 || newC<0 ||newC>=5)
					break;
				if(check[newR][newC]==false)
					break;
				
				newR = newR+dr[i];
				newC = newC+dc[i];
				count++;
			}
			
			if(i%2==1) {
				if(count==5) {
					cnt++; //여러방향으로 빙고가 만들어질 수 있으니 모든 경우를 다 해봐야 한다.
					if(cnt==3) return; //대신 3빙고가 되면 결과를 출력할 수 있으니 return
				}
				count=1;
			}
		}
	}

	/**
	 * 해당 값의 위치를 반환해주는 함수
	 * @param number -위치를 찾고자하는 값
	 * @return (r,c) - 찾은 위치를 배열에 담아서 리턴 / 못 찾을 경우 null
	 */
	public static int[] getLoc(int number) {
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				if(bingo[r][c]==number) {
					return new int[] {r,c};
				}
			}
		}
		return null;
	}
	
}
