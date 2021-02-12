package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1592_영식이와친구들 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int count=0;
		//사람이 N명일 때, 각 번호에 맞는 인덱스 사용을 위해서 +1 크기 할당
		// N=5일 때, 1 2 3 4 5 -> 각 사람 번호에 맞는 인덱스로 사용하기 위함
		int[] arr = new int[N+1];
		//패스를 받는 사람 번호, 첫 번째는 1번 사람
		int pass = 1;
		
		while(true) {
			//패스를 받은 사람의 공 받은 횟수+1
			arr[pass]++;
			
			//공을 받은 횟수가 M이 되면 끝
			if(arr[pass]==M)
				break;
			
			//던진 횟수가 짝수일 때 -> 반시계
			if(arr[pass]%2 ==0 ) {
				//시계방향으로 L번째, pass-L
				pass-=L;
				
				//0이하가 될 경우, N만큼 더해주면 공을 받는 사람의 번호가 나옴
				if(pass<=0)
					pass+=N;
			}
			
			//홀수일 경우 -> 시계방향
			else {
				//시계방향으로 L번째, pass+L
				pass+=L;
				
				//N을 넘어갈 경우, N만큼 빼주면 공을 받는 사람의 번호가 나옴
				if(pass>N)
					pass-=N;
			}
			//공을 패스하는 횟수 (공 던지는 횟수)
			count++;
		}
		
		System.out.println(count);
	}

}
