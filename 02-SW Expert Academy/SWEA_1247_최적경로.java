package com.ssafy.day0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {


	static class Location implements Comparable<Location> {
		int x, y;

		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Location [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Location o) {
			return this.x - o.x;
		}
	}

	static int N, ans;
	static ArrayList<Location> list;
	static int[] input;
	static Location company;
	static Location home;
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(rb.readLine());
			N = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();

			st = new StringTokenizer(rb.readLine());

			company = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			input = new int[N];
			
			for (int i = 0; i < N; i++) {
				list.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				input[i]=i;
			}

			Collections.sort(list);

			ans = Integer.MAX_VALUE;
			getMinDistance();
			System.out.println("#" + tc + " " + ans);
		}

	}

	public static void getMinDistance() {

		// 각 집들의 순열을 구하기
		do {
			//System.out.println(Arrays.toString(input));
			
			int sum =0;
			
			for(int i=1; i<N; i++) {
				Location l1 = list.get(input[i-1]);
				Location l2 = list.get(input[i]);
				
				sum+= (Math.abs(l1.x-l2.x)+Math.abs(l1.y-l2.y));
			}
			
			//회사  - 1번 집
			sum+=(Math.abs(company.x-list.get(input[0]).x)+Math.abs(company.y-list.get(input[0]).y));
			
			//마지막 집 - 집
			sum+=(Math.abs(home.x-list.get(input[N-1]).x)+Math.abs(home.y-list.get(input[N-1]).y));
			
			ans = Math.min(ans, sum);
		} while (np());

	}

	public static boolean np() {

		int i = N - 1;

		while (i > 0 && input[i - 1] >= input[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (input[i - 1] >= input[j])
			--j;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = input[i];
		input[i]=input[j];
		input[j]=temp;
	}
	
}
