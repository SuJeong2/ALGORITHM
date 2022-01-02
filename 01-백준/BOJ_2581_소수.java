package com.algo2022.Jan.day0102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2581_소수 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=M; i<=N; i++) {
			if(isPrim(i)) {
				list.add(i);
			}
		}
		
		if(list.size()==0) {
			System.out.println(-1);
		}
		else {
			int sum = list.stream().mapToInt(Integer::intValue).sum();
			int min = list.get(0);
			
			System.out.println(sum);
			System.out.println(min);			
		}
	}

	private static boolean isPrim(int i) {

		if(i==1) return false;
		
		for(int j=2; j<i; j++) {
			if(i%j==0) {
				return false;
			}
		}
		
		return true;
	}

}
