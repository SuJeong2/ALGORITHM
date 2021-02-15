package 백준;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_15651_NM3 {

	public static int numbers[];
	public static int n,m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//중복을 허용하는 순열, nPm
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		numbers = new int[m];
		
		try {
			perm(0);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void perm(int cnt) throws IOException {
		if(cnt==m) {
			for(int i=0; i<m; i++) {
				bw.write(numbers[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			numbers[cnt]=i;
			perm(cnt+1);
		}
		
	}

}
