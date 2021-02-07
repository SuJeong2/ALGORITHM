package algo.study.bj;

import java.util.Scanner;

public class BJ_15650_NM2 {

	public static int numbers[];
	public static int n,m ;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		numbers = new int[m];
		
		comb(0,1);
	}
	
	public static void comb(int cnt, int start) {
		
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<=n; i++) {
			numbers[cnt]=i;
			comb(cnt+1, i+1);
		}
		
	}

}
