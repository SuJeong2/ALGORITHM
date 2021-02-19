package com.ssafy.day0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14696_딱지놀이 {

	static int A,B;
	static int[] aCard, bCard;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			
			aCard = new int[5];
			bCard = new int[5];
			
			st = new StringTokenizer(rb.readLine());
			A = Integer.parseInt(st.nextToken());
			for(int j=0; j<A; j++)
				aCard[Integer.parseInt(st.nextToken())]++;
			
			st = new StringTokenizer(rb.readLine());
			B = Integer.parseInt(st.nextToken());
			for(int j=0; j<B; j++)
				bCard[Integer.parseInt(st.nextToken())]++;

			char result = getWinner();
			System.out.println(result);
		}
	}
	
	public static char getWinner() {
		char result = 'D';
		
		for(int i=4; i>0; i--) {
			if(aCard[i]==bCard[i]) continue;
			
			if(aCard[i]>bCard[i]) {
				result='A';
				break;
			}
			else {
				result='B';
				break;
			}
		}
		
		return result;
	}

}
