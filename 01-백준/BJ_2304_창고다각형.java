package com.ssafy.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Warehouse{
	int L,H;
	
	public Warehouse(int L, int H) {
		this.L=L;
		this.H=H;
	}

	public int getH() {
		return H;
	}

	public int getL() {
		return L;
	}
	
	@Override
	public String toString() {
		return "Warehouse [L=" + L + ", H=" + H + "]";
	}
}

public class BJ_2304_창고다각형 {

	static ArrayList<Warehouse> list;

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(rb.readLine());
			list.add(new Warehouse(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
        //창고 번호 순으로 정렬
		Collections.sort(list, new Comparator<Warehouse>() {
			@Override
			public int compare(Warehouse o1, Warehouse o2) {
				return o1.L-o2.L;
			}
		});
		
        //제일 높은 빌딩을 찾아서 [번호, 높이] 저장
		int[] max = getMaxHigh();
		
		int result=0; //창고 크기 저장할 변수
        
        //첫번째 창고부터 제일 높은 창고까지 계산
		int[] high = new int[2];
		high[0] = list.get(0).getL(); //첫번째 창고 번호
		high[1] = list.get(0).getH(); //첫번째 창고 높이
		for(int i=1; i<=max[0]; i++) {
			if(high[1] <= list.get(i).getH()) {
                //현재보다 높은 창고나 나오면 이때까지의 넓이 계산
                //현재 창고의 번호와 높이를 high에 넣어줌
				result += (high[1] * (list.get(i).getL()-high[0]));
				high[0]=list.get(i).getL();
				high[1]=list.get(i).getH();
			}
		}
		
        //제일 높은 창고의 넓이 계산
		result+=max[1];
		
        //뒤에서부터 가장 높은 창고까지 계산, 방식은 위에랑 같음
		high[0] = list.get(list.size()-1).getL();
		high[1] = list.get(list.size()-1).getH();
		
		for(int i=N-1; i>=max[0] ;i--) {
			if(high[1] <= list.get(i).getH()) {
				result += (high[1] * (high[0]-list.get(i).getL()));
				high[0]=list.get(i).getL();
				high[1]=list.get(i).getH();
			}
		}
		
		System.out.println(result);
	}

	public static int[] getMaxHigh() {
		int max = Integer.MIN_VALUE;
		int[] maxWH = new int[2];
		
		for(int i=0; i<list.size(); i++) {
			//제일 높은 창고의 번호와 높이를 저장해서 리턴
            //제일 높은 창고가 여러개일 경우 맨 처음것을 저장
			if(max<list.get(i).getH()) {
				max=list.get(i).getH();
				maxWH[0]=i;
				maxWH[1]=list.get(i).getH();
			}
		}
		
		return maxWH;
	}
}