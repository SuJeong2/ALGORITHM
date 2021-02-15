package SWEA;

import java.util.Scanner;

public class SWEA_1940_가랏RC카 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			int n = sc.nextInt();
			int choice, speed =0 , total =0 ;
			
			for(int i=0; i<n; i++) {
				choice = sc.nextInt();
				//speed = sc.nextInt();
				
				switch(choice) {
				case 0:
					break;
				case 1:
					speed += sc.nextInt();
					break;
				case 2:
					speed -=sc.nextInt();
					if(speed<0) speed=0;
					break;
				}
				total += (1*speed);
			}
			
			//출력
			System.out.println("#"+tc+" "+total);
		}

	}

}
