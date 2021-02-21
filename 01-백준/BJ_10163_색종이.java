package com.ssafy.day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163_색종이 {

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] area = new int[101][101];
		int[] count = new int[N+1];
		
		int x,y,w,h;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(rb.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int r=x; r<x+w; r++) {
				for(int c=y; c<y+h; c++) {
					if(area[r][c]!=0)
						count[area[r][c]]--; //만약 이미 색종이가 있었다면 그 색종이 번호의 넓이 감소
					area[r][c]=i; //해당 부분을 현재 색종이 번호로 바꿔줌
					count[i]++; //현재 색종이 번호의 넓이 증가
				}
			}
		}

		for(int i=1; i<=N; i++)
			System.out.println(count[i]);
		/*
		int count;
		for(int i=1; i<=N; i++) {
			count=0;
			for(int r=0; r<101; r++) {
				for(int c=0; c<101; c++) {
					if(area[r][c]==i) count++;
				}
			}
			System.out.println(count);
		}
		*/
	}

}
