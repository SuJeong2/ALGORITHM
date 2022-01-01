package com.algo2022.Jan;

import java.util.Scanner;

public class BOJ_3460_이진수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int T=0; T<t; T++) {
			int n = sc.nextInt();
			int x=0, count=0;
			
			while(n!=0) {
				x = n%2;
				n = n/2;
				
				if(x==1) {
					System.out.print(count+" ");
				}
				
				count++;
			}
			
			System.out.println();
		}

	}

}
