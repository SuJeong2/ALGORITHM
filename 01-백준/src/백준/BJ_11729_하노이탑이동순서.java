package 백준;

import java.util.Scanner;

public class BJ_11729_하노이탑이동순서 {

	static StringBuilder sb=null;
	static int count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		Hanoi(n , 1 , 2, 3);
		
		System.out.println(count);
		System.out.println(sb);
	}
	
	public static void Hanoi(int n, int from, int temp, int to) {
		if(n==0) {
			return;
		}
		//n-1개를 시작 -> 임시로 이동
		Hanoi(n-1, from, to, temp);
		
		//n을 시작->목적으로 이동
		count++;
		sb.append(from+" "+to+"\n");
		
		//n-1개를 임시 -> 목적으로 이동
		Hanoi(n-1, temp, from, to);
	}

}
