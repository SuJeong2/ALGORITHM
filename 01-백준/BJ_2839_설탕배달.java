package 백준;

import java.util.Scanner;

public class BJ_2839_설탕배달 {

	public static void main(String[] args) {
		//백준
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 0;

		while (N > 0) {
			if (N % 5 == 0) {
				N -= 5;
				count++;
			}
			else {
				N -= 3;
				count++;
			}
		}

		System.out.println((N != 0) ? -1 : count);
	}

}
