package algo.study.bj;

import java.util.Scanner;

public class BJ_1912_연속합 {

	static int N;
	static int[] arr;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		isSelected = new boolean[N];
		
	
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int sum=0, max=Integer.MIN_VALUE;	

		for(int i=0; i<N; i++) {
			//sum+=arr[i];
			
			if(sum+arr[i]>max) {
				sum+=arr[i];
				max=sum;
			}
			else {
				sum=0;
			}
		}
		
		System.out.println(max);
	}
}
