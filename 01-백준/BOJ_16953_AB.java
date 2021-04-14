package com.ssafy.Apr.day0414;

import java.util.Scanner;

public class BOJ_16953_AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		int count=0;
		while(true) {
			
			if(y<x) {
				count=-1;
				break;
			}

			if(x==y) {
				break;
			}
			
			if(y%2==0) {
				y=y/2;
			}
			else {
				//맨 마지막 숫자가 1이면 1을 없앤다
				if(y%10==1) y=y/10;
				else {//1이 아니면 불가능->2로도 못나누고, 1을 없애도 안됨
					count=-1;
					break;
				}
			}
			count++;
			
		}
		
		System.out.println(count==-1? -1 : count+1);
		sc.close();

	}

}
