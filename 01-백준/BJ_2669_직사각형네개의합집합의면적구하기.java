package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] check = new boolean[101][101];

		int x, y, p, q;
		int count=0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(rb.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			for (int r = x; r < p; r++) {
				for (int c = y; c < q; c++) {
					if(check[r][c]==false) {
						check[r][c] = true;
						count++;
					}
				}
			}
		}

//		int count = 0;
//		for (int i = 0; i <= 100; i++) {
//			for (int j = 0; j <= 100; j++) {
//				if (check[i][j] == true)
//					count++;
//			}
//		}

		System.out.println(count);
	}

}
