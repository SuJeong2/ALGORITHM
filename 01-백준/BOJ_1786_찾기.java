package com.ssafy.Mar.day0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		char[] T = rb.readLine().toCharArray();
		char[] P = rb.readLine().toCharArray();
		
		int tLength = T.length;
		int pLength = P.length;
		int[] fail = new int[pLength];
		
		for(int i=1, j=0; i<pLength; i++) {
			
			while(j>0 && P[i] != P[j]) {
				j=fail[j-1];
			}
			
			if(P[i]==P[j]) {
				fail[i]=++j;
			}
		}
		//System.out.println(Arrays.toString(fail));
		
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0, j=0; i<tLength; i++) {
			while(j>0 && T[i]!=P[j]) {
				j=fail[j-1];
			}
			
			if(T[i]==P[j]) {
				if(j==pLength-1) {
					cnt++;
					list.add( (i+1) - pLength +1);
					j=fail[j];
				}else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}
