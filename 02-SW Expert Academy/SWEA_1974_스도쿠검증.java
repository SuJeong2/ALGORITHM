package SWEA;

import java.util.Iterator;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {

	static int T;
	static int N=9;
	static int K=N/3;
	static int[][] sudo;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			sudo = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sudo[i][j]=sc.nextInt();
				}
			}
			
			boolean isPossible=true;
			
			//로직
			//행을 비교, 내려가면서
			for(int r=0; r<N && isPossible; r++) {
				isPossible = rowCheck(new boolean[N], r);
			}
			
			//열을 비교,
			for(int c=0; c<N && isPossible; c++) {
				isPossible = colCheck(new boolean[N], c);
			}
			
			//3*3 씩 비교해줘야 함
			for(int r=0; r<N && isPossible; r=r+K) {
				for(int c=0; c<N && isPossible; c=c+K) {
					isPossible = Check(new boolean[N], r, c);
				}
			}
			
			System.out.println("#"+tc+" "+ (isPossible?1:0) );
			
		}
		
	}

	private static boolean Check(boolean[] v, int r, int c) {
		
		for(int i=r; i<r+K; i++) {
			for(int j=c; j<c+K; j++) {
				if(v[sudo[i][j]-1] == true) return false;
				else v[sudo[i][j]-1] =true;
			}
		}
		
		return true;
	}

	private static boolean rowCheck(boolean[] v, int r) {
		
		//1-9까지의 수를 배열 v - 인덱스가 0부터 8까지 담아야 하기 때문에 -1
		for(int c=0;c<N;c++) {
			if(v[sudo[r][c]-1] == true) return false;
			else v[sudo[r][c]-1] =true;
		}
		return true;
	}
	private static boolean colCheck(boolean[] v, int c) {
		
		//1-9까지의 수를 배열 v - 인덱스가 0부터 8까지 담아야 하기 때문에 -1
		for(int r=0; r<N; r++) {
			if(v[sudo[r][c]-1] == true) return false;
			else v[sudo[r][c]-1] =true;
		}
		return true;
	}

}
