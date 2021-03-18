package com.ssafy.Mar.day0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_7701_염라대왕의이름정렬 {

	static int N;
	static ArrayList<String> list;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(rb.readLine());
			N = Integer.parseInt(st.nextToken());
			
			HashSet<String> hash = new HashSet<String>();
			
			String line;
			for(int i=0; i<N; i++) {
				line = rb.readLine();
				hash.add(line);
//				if(list.contains(line)) continue; //중복체크. 중복이면 추가 안함
//				list.add(line);
			}
			
			list = new ArrayList<String>(hash);
			//정렬
			Collections.sort(list, new Comparator<String>() {
				public int compare(String o1, String o2) {
					if(o1.length() == o2.length()) { //길이가 같으면
						return o1.compareTo(o2); //사전식 정렬
					}
					return o1.length()-o2.length();
				}
	
			});
			
			//결과
			System.out.println("#"+tc);
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
			
		}
	}

}
