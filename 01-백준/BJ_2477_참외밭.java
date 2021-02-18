package com.ssafy.day0218;

import java.util.Scanner;

/*
7
3 30
1 60
3 20
1 100
4 50
2 160

7
1 60
3 20
1 100
4 50
2 160
3 30
 */
public class BJ_2477_참외밭 {

	static int K, smallBox=0;
	static int[][] info;
	static int garoMax;
	static int seroMax;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		info = new int[7][2];
		garoMax = Integer.MIN_VALUE;
		seroMax = Integer.MIN_VALUE;

		for (int i = 0; i < 6; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();

			if (info[i][0] == 3 || info[i][0] == 4)
				garoMax = Math.max(garoMax, info[i][1]);
			if (info[i][0] == 1 || info[i][0] == 2)
				seroMax = Math.max(seroMax, info[i][1]);
		}

		for (int i = 0; i < 6; i++) {
			if (getSmallBox(info[i][0], i))
				break;
		}
		
		System.out.println(((seroMax * garoMax) - (smallBox)) * K);
	}

	public static boolean getSmallBox(int dir, int i) {
		int max = 0;
		if (dir == 1 || dir == 2) {
			max = seroMax;
		}
		if (dir == 3 || dir == 4) {
			max = garoMax;
		}

		if (info[i][1] == max)
			return false;

		int next = i + 1;
		int next2 = i + 2;
		int next3 = i + 3;

		if (next > 5)
			next = next - 6;
		if (next2 > 5)
			next2 = next2 - 6;
		if (next3 > 5)
			next3 = next3 - 6;
		
		if(info[next][1]==seroMax || info[next][1]==garoMax) return false;
		if(info[next2][1]==seroMax || info[next2][1]==garoMax) return false;
		if(info[next3][1]==seroMax || info[next3][1]==garoMax) return false;
		
		smallBox = info[next][1] * info[next2][1];
		return true;
	}
}
