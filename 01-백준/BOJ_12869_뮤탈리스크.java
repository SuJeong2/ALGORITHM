package com.ssafy.May.day0501;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_12869_뮤탈리스크 {

	static int minCnt=Integer.MAX_VALUE;
	static int attack[], visited[][][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[3];
		attack = new int[] {9,3,1};
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}

		visited = new int[61][61][61];
		doAttack(arr[0], arr[1], arr[2], 0);
		
		System.out.println(minCnt);
		
	}

	private static void doAttack(int i, int j, int k, int cnt) {
		
		if(i<0) i=0;
		if(j<0) j=0;
		if(k<0) k=0;
		
		//횟수가 최솟값보다 크면 -> 최소공격횟수가 될 수 없다.
		if(cnt>=minCnt)
			return;

		//3개의 값이 전부 0이하가 되면 공격이 끝남을 의미
		if(i<=0 && j<=0 && k<=0) {
			minCnt=Math.min(minCnt, cnt);
			return;
		}
		
		/*
		 * 3 10 7
		 * 10 7 3
		 * 
		 *  같은 경우는 -> 순서만 다를 뿐, 같은 경우임
		 *  방문체크를 해서, 반복을 줄여준다
		 */
		int[] temp = new int[3];
		temp[0]=i;
		temp[1]=j;
		temp[2]=k;
		Arrays.sort(temp);
		
		i=temp[2];
		j=temp[1];
		k=temp[0];
		
		if(visited[i][j][k]==1) {
			return;
		}
		else {
			visited[i][j][k]=1;
		}
		
		doAttack(i-attack[0], j-attack[1], k-attack[2], cnt+1);
		doAttack(i-attack[0], j-attack[2], k-attack[1], cnt+1);
		doAttack(i-attack[1], j-attack[0], k-attack[2], cnt+1);
		doAttack(i-attack[1], j-attack[2], k-attack[0], cnt+1);
		doAttack(i-attack[2], j-attack[0], k-attack[1], cnt+1);
		doAttack(i-attack[2], j-attack[1], k-attack[0], cnt+1);
	}

}
