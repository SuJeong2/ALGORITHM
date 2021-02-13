package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*

4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16
 */
public class SWEA_9229_한빈이와SpotMart {

	static int[] weight;
	static int[] numbers;
	static int N,M, result;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(reader.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());

		for(int tc = 1; tc<=T; tc++) {
			
			st = new StringTokenizer(reader.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			weight = new int[N];
			numbers = new int[N];
			
			st = new StringTokenizer(reader.readLine(), " ");
			for(int i=0; i<N; i++)
				weight[i] = Integer.parseInt(st.nextToken());
			
			result = Integer.MIN_VALUE;
			flag=false;
			
			getMax(0,0);
			
			//결과
			System.out.println("#"+tc+" "+ (flag==true ? result : -1));
		}

	}
	
	public static void getMax(int cnt, int start) {
		if(cnt==2) {
			int sum=0;
			for(int i=0; i<2; i++) {
				sum+=numbers[i];
			}
			
			if(sum<=M) {
				flag = true;
				result = Math.max(sum, result);
			}
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt]=weight[i];
			getMax(cnt+1, i+1);
		}
		
	}

}
