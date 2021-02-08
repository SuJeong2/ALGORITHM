

import java.util.Scanner;

public class SWEA_1217_SW4_거듭제곱 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N, M;
		
		for(int tc = 1; tc<=10; tc++) {
			sc.nextInt();
			
			N=sc.nextInt();
			M=sc.nextInt();
			
			//System.out.println(N+" "+M);
			System.out.println("#"+tc+" "+getDoubleSquare(N,M));
		}

	}
	
	public static int getDoubleSquare(int N, int M) {
		if(M==0)
			return 1;
		
		return N*getDoubleSquare(N,M-1);
	}

}
