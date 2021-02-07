package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {

	static int T,N,M, result;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			N=sc.nextInt();
			M=sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int i=0; i<N; i++) {
				A[i]=sc.nextInt();
			}
			for(int i=0; i<M; i++) {
				B[i]=sc.nextInt();
			}
			
			//N이 크면 swap
			if(N>M) {
				int[] temp = A;
				A=B;
				B=temp;
				
				int temp2 = M;
				M=N;
				N=temp2;
			}
			
			int max = Integer.MIN_VALUE;
			
//			System.out.println(Arrays.toString(A));
//			System.out.println(Arrays.toString(B));
			
			int val = M-N+1;
			
			for(int i=0; i<val; i++) {
				int sum=0;
				for(int j=i; j<i+N; j++) {
					sum+=(A[j-i] * B[j]);
				}
				if(max<sum)
					max=sum;
			}
			
			//출력
			System.out.println("#"+tc+" "+max);
			
			
		}

	}
	
}
