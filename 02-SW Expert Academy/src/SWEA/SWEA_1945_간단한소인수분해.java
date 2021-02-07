package SWEA;

import java.util.Scanner;

public class SWEA_1945_간단한소인수분해 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] arr = new int[] {11,7,5,3,2};
		int[] count;
		int n;
		
		for(int tc = 1 ; tc<=T; tc++) {
			count = new int[5];
			
			n=sc.nextInt();
			
			for(int i=0; i<5; i++) {
				int v = arr[i];
				while(true) {
					if(n%v == 0) {
						count[i]++;
						
						n=n/v;
						
						if(n==1)
							break;
					}
					
					else {
						break;
					}
				}
				
			}
			
			System.out.print("#"+tc+" ");
			for(int i = 4; i>=0; i--)
				System.out.print(count[i]+" ");
			System.out.println();
		}
		
		
	}

}
