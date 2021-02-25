package com.ssafy.day0225;

import java.util.Scanner;

public class BJ_10157_자리배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		
		int index=0, sw=1;
		int ansY=0, ansX=1;

		if(x*y<k) {
			System.out.println(0);
			System.exit(0);
		}
		
		while(true) {
			x--;
			for(int i=0; i<y; i++) {
				index++;
				ansY+=sw;
				if(index==k) {
					System.out.println(ansX+" "+ansY);
					System.exit(0);
				}
			}
			y--;
			for(int i=0; i<x; i++) {
				index++;
				ansX+=sw;
				if(index==k) {
					System.out.println(ansX+" "+ansY);
					System.exit(0);
				}
			}
			
			sw*=-1;
		}
	}
}
