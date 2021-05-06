package com.ssafy.May.day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {

	static String A, B;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			B = st.nextToken();
			
			visited = new boolean[10000];
			System.out.println(getMinCal(A,B));
		}

	}

	private static String getMinCal(String A, String B) {
		
		Queue<String[]> queue = new LinkedList<String[]>();
		queue.offer(new String[] {A, ""});
		
		while(!queue.isEmpty()) {
			String[] cur = queue.poll();
			
			int temp = Integer.parseInt(cur[0]);
			if(visited[temp]) continue;
			
			visited[temp] = true;
				
			if(cur[0].equals(B)) {
				return cur[1];
			}
			
			//같지 않다면 4가지의 계산을 해야 한다.
			
			//D연산
			queue.offer(new String[] { String.valueOf((temp*2)%10000) , cur[1]+"D"});
			
			//S연산
			queue.offer(new String[] { String.valueOf(temp-1<0? 9999 : temp-1) , cur[1]+"S"});
			
			//L연산
			int Ltemp = temp;
			Ltemp = (temp%1000)*10 + (temp/1000);
			queue.offer(new String[] { delZero(String.valueOf(Ltemp)) , cur[1]+"L"});
			
			//R연산
			int Rtemp = temp;
			Rtemp = (temp/10) + (temp%10)*1000;
			queue.offer(new String[] {delZero(String.valueOf(Rtemp)),  cur[1]+"R"});
		}
		
		
		return null;
	}

	private static String delZero(String temp) {
		if(temp.equals("0")) return temp; 
		int cnt=0;
		for(int i=0; i<temp.length(); i++) {
			if(temp.charAt(i) == '0') {
				cnt++;
			}
			else {
				break;
			}
		}
		
		return temp.substring(cnt, temp.length());
	}

}
