package com.ssafy.day0220;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BJ_2605_줄세우기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(list.size()-sc.nextInt(), i+1);
		}
		
		for(int i=0; i<N; i++)
			System.out.print(list.get(i)+" ");
		
	}

}
