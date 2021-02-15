package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1 {

	static int N,M,R, T;
	static int[][] arr;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {

		BufferedReader rb= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(rb.readLine());
			for(int j=0; j<M; j++)
				arr[i][j]=Integer.parseInt(st.nextToken());
		}
		
		//System.out.println(Arrays.deepToString(arr));
		
		//T-그룹 수
		T=Math.min(N, M) /2;
		
		for(int r=1; r<=R; r++) {
			rotate();
		}

		printArray();
	}
	
	public static void printArray() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}

	public static void rotate() {
		//i=0일 때, 가장 바깥쪽
		int r,c;
		int temp, next;
		int after=0;
		int newR, newC;

		for(int i=0; i<T; i++) {
			//시작점
			r=i; c=i;
			temp = arr[r][c];
			
			for(int dir =0 ; dir<4; dir++) {
				
				while(true) {
					
					
					newR = r + dx[dir];
					newC = c + dy[dir];
					
					
					if(newR<0+i || newC<0+i || newR>=(N-i) || newC>=(M-i)) {
						break;
					}
					
					next=arr[newR][newC];
					arr[newR][newC]=temp;
					temp=next;
				
					r= newR;
					c=newC;
				}
			}

		}
	}
}
