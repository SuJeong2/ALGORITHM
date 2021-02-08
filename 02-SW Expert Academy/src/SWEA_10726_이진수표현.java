

import java.util.Scanner;

public class SWEA_10726_이진수표현 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M;
		
		for(int tc = 1; tc<=T; tc++) {
			N=sc.nextInt();
			M=sc.nextInt();
			
			String s = Integer.toBinaryString(M);
			//System.out.println(s);
			
			boolean flag = true;
			for(int i=s.length()-1; i>=s.length()-N; i--) {
				if(s.length()<N) {
					flag=false;
					break;
				}
				if(s.charAt(i) == '0') {
					flag=false;
					break;
				}
			}
			
			System.out.println("#"+tc +" "+ (flag == true ? "ON" : "OFF") );
		}
	}
}