package com.ssafy.Jun.day0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = new StringTokenizer(br.readLine()).nextToken();
		String bomb = new StringTokenizer(br.readLine()).nextToken();
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<line.length(); i++) {
			stack.push(line.charAt(i));
			
			if(line.charAt(i) == bomb.charAt(bomb.length()-1)) {
				boolean flag = true;
				int temp = stack.size();
				if(temp<bomb.length()) continue;
				for(int j=bomb.length()-1; j>=0; j--) {
					if(bomb.charAt(j)!=stack.elementAt(--temp)) flag = false; 
				}
				
				if(flag) {
					for(int j=0; j<bomb.length(); j++)
						stack.pop();
				}
			}
			
		}

		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			for(Character c : stack)
				sb.append(c);
			
			System.out.println(sb.toString());
		}
	}

}
