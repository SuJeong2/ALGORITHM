package algo.study.bj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_15656_NM7 {

	public static int numbers[]; //순열 값을 넣을 배열
	public static int arr[];
	public static int n,m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		numbers = new int[m];
		arr = new int[n];
		
		int max =0;
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
			if(max<arr[i])
				max = arr[i];
		}
		
		Arrays.sort(arr);

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
		
		for(int i=0; i<n; i++) {
			numbers[cnt]=arr[i];
			perm(cnt+1);
		}
	}

}
