package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
3
6
A B C D E F
4
JACK QUEEN KING ACE
5
ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA
 */
public class SWEA_3499_퍼펙트셔플 {

	static int T, N, half;
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		T=sc.nextInt();
		System.out.println(T);
		for(int tc= 1; tc<=T; tc++) {
			N = sc.nextInt();
			
			reader.readLine();
			String[] tokens = reader.readLine().split(" ");
			
			half = N/2;
			
			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<String>();
			
			if(N%2 !=0) half =half+1;
			
			for(int i=0; i<half; i++) {
				queue1.offer(tokens[i]);
			}
			for(int i=half; i<N; i++) {
				queue2.offer(tokens[i]);
			}
			
			StringBuilder sb = new StringBuilder();
			while(!queue1.isEmpty()) {
				sb.append(queue1.poll()+" ");
				
				if(queue2.isEmpty())
					break;
				
				sb.append(queue2.poll()+" ");
			}
			
			System.out.println("#"+tc+" "+sb);
		}
		
	}

}
