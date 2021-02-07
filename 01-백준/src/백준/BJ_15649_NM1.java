package 백준;

import java.util.Scanner;

public class BJ_15649_NM1 {

	public static int numbers[];
	public static boolean isSelected[];
	public static int n,m ;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		numbers = new int[m];
		isSelected = new boolean[n+1];
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		
		//기저조건, m개를 다 뽑았을 경우
		if(cnt==m) {
			for(int k=0; k<m; k++) {
				System.out.print(numbers[k]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for(int k=1; k<=n; k++) {
			if(isSelected[k]==true) continue;
			
			numbers[cnt]=k;
			isSelected[k]=true;
			
			perm(cnt+1);
			
			isSelected[k]=false;
		}
		
	}

}
