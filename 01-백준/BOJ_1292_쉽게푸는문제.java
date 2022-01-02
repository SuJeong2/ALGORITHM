package com.algo2022.Jan.day0102;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1292_쉽게푸는문제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int count =1;
		
		while(list.size()<=a+b) {
			for(int i=1; i<=count; i++)
				list.add(count);
			count++;
		}

		int sum=0;
		for(int i=a-1; i<b; i++) {
			sum+=list.get(i);
		}
		
		System.out.println(sum);
	}

}
