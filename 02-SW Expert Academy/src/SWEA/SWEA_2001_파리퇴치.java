package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2001_파리퇴치 {

	static int T,N,M;
	static int[][] arr;
	static int[][] arrSum;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T=sc.nextInt();
		for(int tc= 1; tc<=T; tc++) {
			
			N=sc.nextInt();
			M=sc.nextInt();
			
			arr = new int[N][N];
			arrSum = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			/*
			//방법 1) 단순 for문 4번 반복
			int sum=0, max=-1;
			
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					
					sum=0;

					for(int a =i; a<i+M; a++) {
						for(int b = j; b<j+M; b++) {
							sum+=arr[a][b];
						}
					}
					if(sum>max)
						max=sum;

				}
			}
			
			System.out.println("#"+tc+" "+max);
			*/
			
			//방법 2)재귀를 조금이라도 적용해본 코드
			for(int row=0; row<N; row++) {
				for(int column = 0; column<=N-M; column++) {
					int cnt=0;
					arrSum[row][column]=arr[row][column]+getValue(row,column+1,cnt+1);
				}
			}
			//System.out.println(Arrays.deepToString(arrSum));
			
			int max=-1;
			
			int[][] result = new int[N-M+1][N-M+1];
			for(int column=0; column<=N-M; column++) {
				for(int row = 0; row<=N-M; row++) {
					int cnt=0;
					result[row][column]=arrSum[row][column]+getValue2(row+1,column,cnt+1);
					if(result[row][column]>max)
						max = result[row][column];
				}
			}

			//System.out.println(Arrays.deepToString(result));
			System.out.println("#"+tc+" "+max);
		}

	}

	public static int getValue(int r, int c, int cnt) {
		if(cnt==M-1)
			return arr[r][c];
		
		return arr[r][c]+getValue(r,c+1,cnt+1);
	}
	public static int getValue2(int r, int c, int cnt) {
		if(cnt==M-1)
			return arrSum[r][c];
		
		return arrSum[r][c]+getValue2(r+1,c,cnt+1);
	}
	
	
}
