package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1493_수의새로운연산 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(rb.readLine());

		int p,q;
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(rb.readLine());
			p=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			
			System.out.println("#"+tc+" "+getNewOperation(p,q));
		}
	}
	
	public static int getNewOperation(int p, int q) {
		int result = 0;
		
		int[] p1 = getNumber(p);
		int[] q1 = getNumber(q);
		
		
		//System.out.println("P1 " + p1[0]+" "+p1[1] + " Q1 "+q1[0]+" "+q1[1]);
		
		//좌표 값 가져옴
		p1=getXY(p1,p);
		q1=getXY(q1,q);
		
		//좌표값을 더함
		int[] point = new int[] {p1[0]+q1[0], p1[1]+q1[1]};
		//System.out.println(Arrays.toString(point));
		
		//다시 번호로 구해야 함
		
		return getResult(point);
	}
	
	public static int getResult (int[] point) {
		int x=0,y=2;
		int count=0;
		int numb=1;
		while(true) {
			count++;
			x++;
			y--;
			
			if(x==point[0] && y==point[1])
				break;
			
			if(y==0) {
				x=1;
				numb++;
				y=numb;
			}
				
		}
		
		return count;
	}
	
	public static int[] getXY(int[] i, int num) {
		int x=1;
		int y=i[1];
		for(int j=1; j<num-i[0]; j++) {
			x++;
			y--;
		}
		
		return new int[] {x,y};
	}
	
	public static int[] getNumber(int i) {
		int sum=1;
		int count=1;
		while(true) {
			if(sum>=i)
				return new int[] {sum-count,count};
			count++;
			sum+=count;
		}
	}
	
}
