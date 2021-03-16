package com.ssafy.Mar.day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static int L, C;
	static char[] list;
	static char[] selectList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		list = new char[C];
		selectList = new char[L];
		
		
		st = new StringTokenizer(rb.readLine(), " ");
		for(int i=0; i<C; i++)
			list[i]=st.nextToken().charAt(0);
		
		Arrays.sort(list);
		//System.out.println(Arrays.toString(list));
		
		comb(0,0);
	}

	private static void comb(int cnt, int start) {
		if(cnt==L) {
			int alph_a=0;
			int alph_b=0;
			for(int i=0; i<L ; i++) {
				switch(selectList[i]) {
				case 'a': case 'e': case'i' : case 'o': case'u':
					alph_a++;
					break;
				default : alph_b++; break;
				}
			}
			
			
			if(alph_a==0 || alph_b<2) return;

			for(int i=0; i<L ; i++) {
				System.out.print(selectList[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<list.length; i++) {
			selectList[cnt]=list[i];
			comb(cnt+1, i+1);
		}
	}
}