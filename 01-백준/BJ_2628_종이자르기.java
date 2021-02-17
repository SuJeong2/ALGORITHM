package com.ssafy.day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(rb.readLine());
		int c = Integer.parseInt(st.nextToken());
		
		int[] row = new int[c+2];
		int[] column = new int[c+2];
		
		int rc, rowCnt=0, colCnt=0;
		for(int i=0; i<c; i++) {
			st = new StringTokenizer(rb.readLine());
			rc = Integer.parseInt(st.nextToken());
			
			if(rc==0)
				row[rowCnt++]=Integer.parseInt(st.nextToken());
			else
				column[colCnt++]=Integer.parseInt(st.nextToken());
		}
		
		row[rowCnt++]=0;
		column[colCnt++]=0;
		row[rowCnt++]=M;
		column[colCnt++]=N;
		row = Arrays.copyOf(row, rowCnt);
		column = Arrays.copyOf(column, colCnt);
		
		//작은 순으로 정렬
		Arrays.sort(row);
		Arrays.sort(column);
	
		int[] row_unit = new int[row.length-1];
		int[] column_unit = new int[column.length-1];
		for(int i=row.length-1; i>=1 ; i--) {
			row_unit[i-1]=row[i]-row[i-1];
		}
		for(int i=column.length-1; i>=1 ; i--) {
			column_unit[i-1]=column[i]-column[i-1];
		}
		
		int result = Integer.MIN_VALUE;
		for(int i=0; i<row_unit.length; i++) {
			for(int j=0; j<column_unit.length; j++) {
				result = Math.max(result, row_unit[i]*column_unit[j]);
			}
		}
		
		System.out.println(result);
		
	}

}
