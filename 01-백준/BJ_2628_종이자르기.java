package com.ssafy.day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2628_종이자르기 {

	static int N, M, c;
	static int[] row, column;
	static BufferedReader rb;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		rb = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(rb.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(rb.readLine());
		c = Integer.parseInt(st.nextToken());
		
		//System.out.println(method1()); //배열만 사용
		//System.out.println(method2()); //ArrayList 활용
		/*
		 method1, method2는 각 구간별 길이를 구해서
		 세로 * 가로 하면서 최댓값 도출
		 */
		System.out.println(method3()); //ArrayList 활용 + 가로세로 최대값만 구해서 결과 리턴
	}
	
	public static int method1() throws IOException {
		row = new int[c+2];
		column = new int[c+2];
		
		int rc, rowCnt=0, colCnt=0;
		
		for(int i=0; i<c; i++) {
			st = new StringTokenizer(rb.readLine());
			rc = Integer.parseInt(st.nextToken());
			
			if(rc==0) {
				row[rowCnt++]=Integer.parseInt(st.nextToken());
			}
			else {
				column[colCnt++]=Integer.parseInt(st.nextToken());
			}
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
		
		return result;
	}
	
	public static int method2() throws IOException {
		ArrayList<Integer> rowList = new ArrayList<>();
		ArrayList<Integer> colList = new ArrayList<>();
		
		int rc, rowCnt=0, colCnt=0;
		for(int i=0; i<c; i++) {
			st = new StringTokenizer(rb.readLine());
			rc = Integer.parseInt(st.nextToken());
			
			if(rc==0) {
				rowList.add(Integer.parseInt(st.nextToken()));
			}
			else {
				colList.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		rowList.add(0);
		rowList.add(M);
		
		colList.add(0);
		colList.add(N);
		
		//작은 순으로 정렬
		Collections.sort(rowList);
		Collections.sort(colList);
	
		int[] row_unit = new int[rowList.size()-1];
		int[] column_unit = new int[colList.size()-1];
		
		//자르는 부분 사이의 길이를 구함
		for(int i=rowList.size()-1; i>=1 ; i--) {
			row_unit[i-1]=rowList.get(i)-rowList.get(i-1);
		}
		for(int i=colList.size()-1; i>=1 ; i--) {
			column_unit[i-1]=colList.get(i)-colList.get(i-1);
		}
		
		//구해진 길이, 가로*세로 하면서 최댓값을 찾음
		int result = Integer.MIN_VALUE;
		for(int i=0; i<row_unit.length; i++) {
			for(int j=0; j<column_unit.length; j++) {
				result = Math.max(result, row_unit[i]*column_unit[j]);
			}
		}
		
		return result;
	}
	
	public static int method3() throws IOException {
		ArrayList<Integer> rowList = new ArrayList<>();
		ArrayList<Integer> colList = new ArrayList<>();
		
		int rc, rowCnt=0, colCnt=0;
		for(int i=0; i<c; i++) {
			st = new StringTokenizer(rb.readLine());
			rc = Integer.parseInt(st.nextToken());
			
			if(rc==0) {
				rowList.add(Integer.parseInt(st.nextToken()));
			}
			else {
				colList.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		rowList.add(0);
		rowList.add(M);
		
		colList.add(0);
		colList.add(N);
		
		//작은 순으로 정렬
		Collections.sort(rowList);
		Collections.sort(colList);
		
		int rowMax = Integer.MIN_VALUE;
		int colMax = Integer.MIN_VALUE;
		
		//가로 세로 최대값을 구해서 곱하면 최대 너비가 나옴
		for(int i=rowList.size()-1; i>=1 ; i--) {
			rowMax=Math.max(rowMax, rowList.get(i)-rowList.get(i-1));
		}
		for(int i=colList.size()-1; i>=1 ; i--) {
			colMax=Math.max(colMax, colList.get(i)-colList.get(i-1));
		}
		
		return rowMax*colMax;
	}

}
