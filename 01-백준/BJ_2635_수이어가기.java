package com.ssafy.day0225;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_2635_수이어가기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer>list;
		List<Integer>result;
		int value, MAX = Integer.MIN_VALUE;
		
		list = new ArrayList<Integer>();
		result = new ArrayList<Integer>();

		for(int i=N; i>=0; i--) {
			list.clear();
			list.add(N);
			list.add(i);

			int index=2;
			while(true) {
				value = list.get(index-2) -list.get(index-1);
				if(value<0)
					break;
				list.add(value);
				index++;
			}

			if(MAX<list.size()) {
				MAX=list.size();
				result.clear();
				result.addAll(list);
			}
		}

		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
	}

}
