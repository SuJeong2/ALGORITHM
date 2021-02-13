package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean[][] check = new boolean[101][101];
		
		int x,y, count=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int a=x; a<x+10; a++) {
				for(int b=y; b<y+10; b++) {
					if(check[a][b]==false) {
						count++;
						check[a][b]=true;
					}
				}
			}
			
		}
		
		System.out.println(count);
	}

}
