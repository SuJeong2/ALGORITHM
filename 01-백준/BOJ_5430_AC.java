package com.ssafy.Jul.day0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	static int n;
	static List<String> arr;
	static String p;
	static boolean flag, flip;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int T = 1; T<=tc ; T++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			s = s.substring(1, s.length()-1);
			String[] temp = s.split(",");

			arr = new LinkedList<String>(); //삭제 연산을 할 떄는 ArrayList보다 LinkedList가 더 빠름
			if(n>0) arr.addAll(Arrays.asList(temp));
			
			flag = true; //error 발생 체크, D 연산이 가능한지 체크
			flip = false; //뒤집히는 연산을 체크하기 위한 변수, false이면 원래 상태, true이면 뒤집힌 상태
			getCalculation();
			
			//결과 출력
			if(flag) {
				if(flip) { //flip된 상태라면 => 뒤집은 다음 출력해야 함
					Collections.reverse(arr);
				}
				String result = arr.toString();
				/*
				 * 출력형식이 [1,2,3,5,8] 이런식이라 공백 제거
				 * arr.toString()하면 [1, 2, 3, 5, 8] 이렇게 나오기 때문
				 * result.trim() 사용하려했으나, 적용이 안돼서 replace 사용 -> 왜 안되는거지?
				 */
				result = result.replace(" ",""); 
				System.out.println(result);
			}
			else {
				System.out.println("error");
			}
			
		}
	}

	private static void getCalculation() {

		for(int i=0; i<p.length(); i++) {
			char operation = p.charAt(i);
			
			if(operation == 'R') {
				//R 연산때마다 Collections.reverse를 하면 매 연산마다 뒤집는 연산이 들어가서 시간초가가 발생했음
				//flip 변수를 사용해서 뒤집는 것처럼 생각하고 풀어야 함
				
				flip = !flip; //뒤집는 연산 -> flip 변수를 반대로 바꿔준다
			}
			if(operation == 'D'){
				if( arr.size()==0 ) { //arr가 비어있는데 연산을 하려고 할 경우
					flag=false;
					return;
				}
				
				if(!flip) //뒤집힌 상태가 아니라면 맨 앞에 수를 제거
					arr.remove(0);
				else //뒤집힌 상태라면, 맨 뒤의 숫자가 맨 앞의 숫자가 되는 것이기 때문에, 마지막 수를 제거
					arr.remove(arr.size()-1);
			}
		}
	}

}
