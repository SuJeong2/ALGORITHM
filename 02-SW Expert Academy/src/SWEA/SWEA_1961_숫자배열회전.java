package SWEA;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] arr;
		int n;
		
		for(int tc = 1 ; tc <= T; tc++) {
			n =sc.nextInt();
			
			arr =new int[n][n];

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			System.out.println("#"+tc);
			
			int count=0;
			int k90=0, k180=n-1, k270=n-1;
			while(count<n) {
				//90도 출력
				for(int i=n-1; i>=0; i--) {
					System.out.print(arr[i][k90]);
				}
				k90++;
				
				System.out.print(" ");
				
				//180도 출력
				for(int i=n-1; i>=0; i--) {
					System.out.print(arr[k180][i]);
				}
				k180--;
				
				System.out.print(" ");
				
				//270도 출력
				for(int i=0; i<n; i++) {
					System.out.print(arr[i][k270]);
				}
				k270--;
				
				System.out.println();
				
				count++;
			}
		}
	}

}
