package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1220_SW5_Magnetic {
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			
			int N = Integer.parseInt(reader.readLine());
			
			map = new int[N][N];
			StringTokenizer st;
			
			for(int i=0; i<N; i++) {				
				String input = reader.readLine();
				st = new StringTokenizer(input);
				for(int k = 0; k < N; k++) {
					map[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int c=0; c<N; c++) {
				int count=0;
				int check = 0;
				
				for(int r=0; r<N; r++) {
					if(map[r][c] == 1)
						check=1;
					//위에 1(N) 현재 2(S) -> 교착상태
					if(check==1 && map[r][c]==2) {
						count++;
						check=0;
					}
				}
				
				result+=count;
			}
			
			System.out.println("#"+tc+" "+result);
		}
		

	}
}
