package 백준;

import java.util.Scanner;

public class BJ_1912_연속합 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		//int max=Integer.MIN_VALUE;
		int[] sum = new int[N];
		
		sum[0]=arr[0];
		int max= sum[0];
		for(int i=1; i<N; i++) {
			//sum[i]=arr[i]+sum[i-1];
			sum[i]=Math.max(arr[i], arr[i]+sum[i-1]);
			
			max = Math.max(max, sum[i]);
		}
		
		System.out.println(max);
	}
}
