package com.ssafy.day0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_개미 {

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(rb.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(rb.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		//남은 자리 채우기
		int x_time = t-(w-p);
		int x_1 = x_time%w;
		int x_2 = x_time/w;
		if(x_2%2==1) p=x_1;
		else p=w-x_1;
		
		int y_time = t-(h-q);
		int y_1 = y_time%h;
		int y_2 = y_time/h;
		if(y_2%2==1) q=y_1;
		else q=h-y_1;
		
		System.out.println(p+" "+q);

		
		
//		int[][] dir = new int[][] {{1,1}, {-1,1}, {-1,-1}, {1,-1} };
//		int way=0;	
		
		
		/*
		for(int time = 0; time<t; time++) {
			p = p+dir[way][0];
			q= q+dir[way][1];
			
			//부딪히는지 확인하기, 벽이 아닐 경우
			if(p>0 && p<w && q>0 && q<h)
				continue;
			
			//벽에 닿을 경우
			if(p==w && way==0)
				way=1;
			if(q==h && way==1)
				way=2;
			if(q==0 && way==2)
				way=1;
			if(p==0 && way==1)
				way=0;
			if(q==h && way==0)
				way=3;
			if(q==0 && way==3)
				way=0;
		}
		*/
		
//		for(int time = 0; time<t; time++) {
//			
//			while(true) {
//
//				p = p+dir[way][0];
//				q = q+dir[way][1];
//				time++;
//				
//				//벽에 닿은 경우
//				if(p<=0 || p>=w || q<=0 || q>=h) {
//					time--;
//					break;
//				}
//			}
//
//			//벽에 닿으면 방향을 바꿔줌
//			if(p==w && way==0)
//				way=1;
//			if(q==h && way==1)
//				way=2;
//			if(q==0 && way==2)
//				way=1;
//			if(p==0 && way==1)
//				way=0;
//			if(q==h && way==0)
//				way=3;
//			if(q==0 && way==3)
//				way=0;
//		}
//		
//		System.out.println(p+" "+q);
		
	}

}
