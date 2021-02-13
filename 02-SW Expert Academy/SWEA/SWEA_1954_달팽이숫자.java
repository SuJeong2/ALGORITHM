package SWEA;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T, n;
		T=sc.nextInt();
		
		for(int t = 1; t <= T; t++){
		
			n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			int value = 1, w =1 ;
			int r = 0, c= -1;
			
			int max = n;
			
			while(value<=n*n) {
				
				//열 증가
				for(int i=0; i<max; i++) {
					c=c+w;
					arr[r][c]=value++;
				}
				
				max--;
				
				//행증가
				for(int j=0; j<max; j++) {
					r=r+w;
					arr[r][c]=value++;
				}
				
				w*=-1;
			}
			
			
			System.out.println("#"+t);
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}

	}

}
