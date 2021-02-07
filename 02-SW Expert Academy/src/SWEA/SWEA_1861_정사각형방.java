package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
1
7
19 26 34 12 25 48 40 
32 43 49 39 28 44 1 
33 14 8 15 23 6 38 
3 21 24 13 9 7 41 
42 17 31 4 45 27 18 
20 29 47 22 30 5 2 
16 46 10 37 36 35 11

 */
/*
테스트 케이스
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2

출력
#1 1 2
#2 3 3
 */
public class SWEA_1861_정사각형방 {
	
	static int T, N;
	static int[][] arr;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			N=sc.nextInt();
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			//System.out.println(Arrays.deepToString(arr));
			
			int[][] location = new int[N*N][];
			
			int index = 0, cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {

					for(int k=0; k<4; k++) {
						int newI = i+dx[k];
						int newJ = j+dy[k];
						if(newI>=0 && newI<N && newJ>=0 && newJ<N) {
							if(arr[newI][newJ]==arr[i][j]+1) {
								location[index++]=new int[] {i,j};
								cnt++;
							}
						}
					}
					
				}
			}
			
			//System.out.println(Arrays.deepToString(location));
			//System.out.println(cnt);
			
			int max=Integer.MIN_VALUE, num=0, temp=-1;
			//int[] result = new int[cnt];
			int result=0;
			index=0;
			
			for(int i= 0; i<cnt; i++) {
				num=0;
				temp=-1;
				
				int r = location[i][0];
				int c = location[i][1];
				int fixr = location[i][0];
				int fixc= location[i][1];
				
				//System.out.println(r+" "+c);
				
				while(true) {

					temp=-1;
					for(int k=0; k<4; k++) {
						int newI = r+dx[k];
						int newJ = c+dy[k];
						if(newI>=0 && newI<N && newJ>=0 && newJ<N) {
							if(arr[newI][newJ]==arr[r][c]+1) {
								num++;
								temp++;
								r=newI;
								c=newJ;
								//System.out.println("next "+num);
								break;
							}
						}
					}
					//System.out.println("===" + r+" "+ c+" "+num);
					if(temp==-1)
						break;
				}
				
				if(max == num) {
					result = (result<arr[fixr][fixc] ? result : arr[fixr][fixc]); 
				}
				
				if(max<num) {
					max=num;
					result = arr[fixr][fixc];
				}
//				if(max<=num) {
//					
//					
//					max=num;
//					result = arr[fixr][fixc];
//					
//					System.out.println("MAX : " + max+ " " + arr[fixr][fixc]);
//					result[index++]=arr[fixr][fixc];
//					System.out.println("MAX : " + max+ " " + result[index-1]);
//					//System.out.println("Max : "+ max + "     result : "+Arrays.toString(result));
//				}
				
			}
			//System.out.println(Arrays.toString(result));
			
//			int small=Integer.MAX_VALUE;
//			for(int i=0; i<index; i++) {
//				small = Math.min(small, result[i]);
//				System.out.println(i+" ,,,, "+small);
//			}
			//출력
			System.out.println("#"+tc+" "+result+" "+(max+1));
		}
	}

}
