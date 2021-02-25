package com.ssafy.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정올_1205_조커 {

	public static void main(String[] args) throws IOException {
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		st = new StringTokenizer(rb.readLine());
		for(int i=0; i<N; i++)
			card[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(card);
		//System.out.println(Arrays.toString(card));
		
		int zeroCnt=0;
		for(int i=0; i<N; i++) {
			if(card[i]!=0) break;
			zeroCnt++;
		}
		
		//모든 숫자가 0일 때, 마지막 숫자를 1로 바꿔주고 구함
		if(zeroCnt==N) {
			zeroCnt--;
			card[N-1]=1;
		}
		
		int MAX = Integer.MIN_VALUE;
		for(int i=zeroCnt; i<N; i++) {
			int len =0; //스트레이트 길이 계산을 위한 변수
			int zero=zeroCnt; //사용 가능한 조커의 개수를 카운팅할 변수
			int start = i; //시작값
			
			while(true) {
				//배열의 마지막 값일 경우, 다음 값이 없으므로 남은 0을 모두 더해주고 끝
				if(start==N-1) {
					len++;
					len+=zero;
					break;
				}
				
				int diff = card[start+1]-card[start]-1;
				
				//차이가 -1이다 -> 두 값이 서로 같다 -> 다음으로 넘어간다
				if(diff==-1) {
					start++;
					continue;
				}
				//차이가 0이다 -> 연속된 수이다 -> 스트레이트 길이를 증가시키고 다음으로 넘어간다
				if(diff ==0) {
					len++;
					start++;
					continue;
				}
				
				//차이가 1이상일 때 -> 조커로 채울 수 있는지 확인
				if(diff<=zero) { //조커로 차이를 채울 수 있는 경우
					len++; //현재 값에 대한 스트레이트 길이 증가
					len+=diff; //차이를 조커로 채울 수 있으니, 채워진만큼 길이 증가
					zero-=diff; //사용한 만큼 조커의 개수 감소
					start++; //다음 수로 넘어간다
				}
				else { //조커가 부족할 경우
					len++; //현재 값에 대한 스트레이트 길이 증가
					len+=zero; //남은 조커로 채우고 끝
					break;
				}
			}
			
			MAX=Math.max(MAX, len);
		}
		System.out.println(MAX);
	}
}