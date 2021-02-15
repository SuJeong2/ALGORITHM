package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {

	static int[][] hambuger;
	static int max;
	static boolean[] isSelected;
	static int T, N, L;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();

			hambuger = new int[N][2];
			isSelected = new boolean[N];

			for (int i = 0; i < N; i++) {
				hambuger[i][0] = sc.nextInt();
				hambuger[i][1] = sc.nextInt();
			}
			//System.out.println(Arrays.deepToString(hambuger));
			max= Integer.MIN_VALUE;
			
			getBest(0);

			System.out.println("#" + tc + " " + max);
		}
	}

	public static void getBest(int cnt) {
		if (cnt == N) {
			int score = 0;
			int cal = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i] == true) {
					score += hambuger[i][0];
					cal += hambuger[i][1];
				}
			}

			if (cal <= L && max < score)
				max = score;

			return;
		}

		isSelected[cnt] = true;
		getBest(cnt + 1);

		isSelected[cnt] = false;
		getBest(cnt + 1);
	}
}
