package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3 {

	static int N,M,R;
	static int[][] arr;
	
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
		
		st = new StringTokenizer(rb.readLine());
		for(int r=1; r<=R; r++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				right90();
				break;
			case 4:
				left90();
				break;
			case 5:
				close();
				break;
			case 6:
				closewise();
				break;
			default:
				break;
			}
		}
		
		printArray();
	}
	
	private static void closewise() {
		int newN=N/2;
		int newM = M/2;
		
		int[][] arr_temp = new int[N][M];
		
		for(int i=0; i<N; i++)
			arr_temp[i] = Arrays.copyOf(arr[i], M);
		
		//2번 구간이 1번 구간으로
		for(int i=0; i<newN; i++) {
			for(int j=0; j<newM; j++) {
				arr[i][j] = arr_temp[i][j+newM];
			}
		}
		
		//3번 구간이 2번 구간으로
		for(int i=0; i<newN; i++) {
			for(int j=newM; j<M; j++) {
				arr[i][j] = arr_temp[i+newN][j];
			}
		}

		//4번 구간이 3번 구간으로
		for(int i=newN; i<N; i++) {
			for(int j=newM; j<M; j++) {
				arr[i][j] = arr_temp[i][j-newM];
			}
		}
		
		//1번 구간이 4번 구간으로
		for(int i=newN; i<N; i++) {
			for(int j=0; j<newM; j++) {
				arr[i][j] = arr_temp[i-newN][j];
			}
		}
		
	}

	private static void close() {
		int newN=N/2;
		int newM = M/2;
		
		int[][] arr_temp = new int[N][M];
		
		for(int i=0; i<N; i++)
			arr_temp[i] = Arrays.copyOf(arr[i], M);
		
		//4번 구간이 1번 구간으로
		for(int i=0; i<newN; i++) {
			for(int j=0; j<newM; j++) {
				arr[i][j] = arr_temp[i+newN][j];
			}
		}
		
		//1번 구간이 2번 구간으로
		for(int i=0; i<newN; i++) {
			for(int j=newM; j<M; j++) {
				arr[i][j] = arr_temp[i][j-newM];
			}
		}

		//2번 구간이 3번 구간으로
		for(int i=newN; i<N; i++) {
			for(int j=newM; j<M; j++) {
				arr[i][j] = arr_temp[i-newN][j];
			}
		}
		
		//3번 구간이 4번 구간으로
		for(int i=newN; i<N; i++) {
			for(int j=0; j<newM; j++) {
				arr[i][j] = arr_temp[i][j+newM];
			}
		}
	}

	private static void left90() {
		right90();
		leftRight();
		upDown();
	}

	private static void right90() {

		int[][] arr_90 = new int[M][N];
		
		for(int c=0; c<M; c++) {
			for(int r=N-1; r>=0; r--) {
				arr_90[c][N-r-1]=arr[r][c];
			}
		}
		
		arr=Arrays.copyOf(arr_90, M);
		
		int temp=M;
		M=N;
		N=temp;
	}

	public static void printArray() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	public static void upDown() {
		int[] temp = new int[M];
		
		for(int r=0; r<N/2; r++) {
			temp = Arrays.copyOf(arr[r], M);
			arr[r]= Arrays.copyOf(arr[N-1-r], M);
			arr[N-1-r]=Arrays.copyOf(temp, M);
		}
	}
	public static void leftRight() {
		int temp;
		
		for(int c=0; c<M/2; c++) {
			for(int r=0; r<N; r++) {
				temp = arr[r][c];
				arr[r][c]=arr[r][M-1-c];
				arr[r][M-1-c]=temp;
			}
		}
	}

}
