package algo.study.bj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_15652_NM4 {

	public static int numbers[];
	public static int n,m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//중복을 허용한 조합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		numbers = new int[m];
		
		try {
			comb(0,1);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void comb(int cnt, int start) throws IOException {
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				bw.write(numbers[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			numbers[cnt]=i;
			comb(cnt+1, i);
		}
	}

}
