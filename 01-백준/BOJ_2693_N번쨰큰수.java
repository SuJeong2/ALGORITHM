package com.algo2022.Jan.day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2693_N번쨰큰수 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});;
			
			System.out.println(list.get(2));
			
			list.clear();
		}
		
	}

}
