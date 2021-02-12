package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2804_크로스워드만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		String line = rb.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(B));
		
		int n=0,m=0;
		outer:for(int i=0; i<A.length; i++) {
			for(int j=0; j<B.length; j++) {
				if(A[i]==B[j]) {
					n=i;
					m=j;
					break outer;
				}
			}
		}

		//결과 출력 형식을 위한 변수, "." 개수 저장
		StringBuilder left= new StringBuilder();
		StringBuilder right = new StringBuilder();
		
		for(int i=0; i<n; i++)
			left.append(".");
		for(int i=n+1; i<A.length; i++)
			right.append(".");
		
		//결과 출력
		for(int i=0; i<B.length; i++) {
			if(i==m) {
				for(int j=0; j<A.length; j++)
					System.out.print(A[j]);
				System.out.println();
			}
			else {
				
				System.out.print(left);
				System.out.print(B[i]);
				System.out.print(right);
				System.out.println();
			}
		}
	}

}
