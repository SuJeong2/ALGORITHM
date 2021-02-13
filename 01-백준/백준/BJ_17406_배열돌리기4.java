package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4 {
	static int N,M,R;
	static int r,c,s;
	static int[][] arr;
	static int[][] arr_copy;
	static int[][] info;
	static boolean[] isSelected;
	static int[] numbers;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader rb= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		info = new int[R][3];
		isSelected = new boolean[R];
		numbers = new int[R];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(rb.readLine());
			for(int j=0; j<M; j++)
				arr[i][j]=Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.deepToString(arr));
		
		//회전 정보 저장
		for(int i=0; i<R; i++) {
			st=new StringTokenizer(rb.readLine());
			info[i][0]=Integer.parseInt(st.nextToken());
			info[i][1]=Integer.parseInt(st.nextToken());
			info[i][2]=Integer.parseInt(st.nextToken());
		}
		
		result = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(result);
	}
	
	public static void arrayCopy() {
		arr_copy = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				arr_copy[i][j] = arr[i][j];
		}
	}

	public static void rotate(int i) {
		int r = info[i][0];
		int c = info[i][1];
		int s = info[i][2];

		//스타트 포인트
		int r1 = r-s-1;
		int c1 = c-s-1;
		
		//엔드 포인트
		int r2 = r+s-1;
		int c2 = c+s-1;
		
		int length = c+s-(c-s)+1;
		int temp, next, newR,newC;
		
		for(int j=0; j<length/2; j++) {
			
			int x = r1+j;
			int y = c1+j;
			
			temp=arr_copy[x][y];
			
			for(int dir=0; dir<4; dir++) {
				
				while(true) {
					
					newR= x+dx[dir];
					newC = y+dy[dir];
					
					if(newR<r1+j || newC<c1+j || newR>r2-j || newC>c2-j) {
						break;
					}
					
					
					next=arr_copy[newR][newC];
					arr_copy[newR][newC]=temp;
					temp=next;
				
					x= newR;
					y=newC;
				}
			}
			
		}
		
	}
	
	public static int getArrVal() {
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			int sum=0;
			for(int j=0; j<M; j++) {
				sum+=arr_copy[i][j];
			}
			min=Math.min(min, sum);
		}

		return min;
	}
	
	public static void perm(int cnt) {
		if(cnt==R) {
			arrayCopy();
			for(int i=0; i<R; i++) {
				rotate(numbers[i]);
			}
			
			result = Math.min(getArrVal(), result);
			return;
		}
		for(int i=0; i<R; i++) {
			if(isSelected[i]==true) continue;
			
			isSelected[i]=true;
			numbers[cnt] = i;
			
			perm(cnt+1);
			
			isSelected[i]=false;
		}
	}
}
