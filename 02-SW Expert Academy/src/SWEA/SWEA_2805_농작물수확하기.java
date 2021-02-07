package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA_2805_농작물수확하기 {

	static int T,N;
	static int[][] arr;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			N = sc.nextInt();
			arr = new int[N][N];
			
			for(int i=0; i <N; i++) {
				String s = sc.next();
				for(int j=0; j<N; j++) {
					arr[i][j] = s.charAt(j) - (int)'0';
				}		
			}
			
			//결과 출력
			System.out.println("#"+tc +" "+farmVal(N));
		}

	}
	
	public static int farmVal(int N) {
		
		int sum=0, num=0;
		
		for(int r = N/2; r>=0; r--) {
			for(int c= num; c<N-num; c++) {
				
				sum=sum+arr[r][c];
				if(N/2==r) continue;
				sum+=arr[N/2+num][c];
			}
			++num;
		}

		return sum;
	}

}
