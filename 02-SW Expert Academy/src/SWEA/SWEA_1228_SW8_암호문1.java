package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1228_SW8_암호문1 {

	static int N, cnt;
	static int[] text;
	static BufferedReader reader;
	static StringTokenizer st;
	static LinkedList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		reader= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int tc=1; tc<=10; tc++) {
			
			list = new LinkedList<Integer>();
			
			st = new StringTokenizer(reader.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(reader.readLine(), " ");
			for(int i=0; i<N; i++) {
				list.addLast(Integer.parseInt(st.nextToken()));
			}
			
			//fu(Integer.parseInt(st.nextToken()));
			makeCiphertext();
			
			//결과 출력
			System.out.print("#"+tc+" ");
			int count=0;
			while(!list.isEmpty() && count<10) {
				System.out.print(list.remove()+" ");
				count++;
			}
		}
	}
	
	public static void makeCiphertext() throws IOException {
		st = new StringTokenizer(reader.readLine(), " ");
		cnt = Integer.parseInt(st.nextToken());
		
		//I x y s----반복
		int x,y;
		st = new StringTokenizer(reader.readLine(), " ");
		for(int i=0; i<cnt; i++) {
			char order = st.nextToken().charAt(0);
			
			switch(order) {
			case 'I':
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<y; j++) {
					list.add(x+j, Integer.parseInt(st.nextToken()));
				}
			}
		}
	}
}
