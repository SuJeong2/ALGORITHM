package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
테스트 케이스

입력
1
9550 9556 9550 9553 9558 9551 9551 9551 
2
2419 2418 2423 2415 2422 2419 2420 2415 
3
7834 7840 7840 7835 7841 7835 7835 7838 
4
4088 4087 4090 4089 4093 4085 4090 4084 
5
2945 2946 2950 2948 2942 2943 2948 2947 
6
670 667 669 671 670 670 668 671 
7
8869 8869 8873 8875 8870 8872 8871 8873 
8
1709 1707 1712 1712 1714 1710 1706 1712 
9
10239 10248 10242 10240 10242 10242 10245 10235 
10
6580 6579 6574 6580 6583 6580 6577 6581


출력
#1 6 2 2 9 4 1 3 0 
#2 9 7 9 5 4 3 8 0 
#3 8 7 1 6 4 3 5 0 
#4 7 5 8 4 8 1 3 0 
#5 3 8 7 4 4 7 4 0 
#6 6 7 5 9 6 8 5 0 
#7 7 6 8 3 2 5 6 0 
#8 9 2 1 7 3 6 3 0 
#9 4 7 8 1 2 8 4 0 
#10 6 8 9 5 8 5 2 0
 */

public class SWEA_SW7_암호생성기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for(int i=0; i<10; i++){
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			int tc = sc.nextInt();
			
			for(int j=0; j<8; j++)
				queue.offer(sc.nextInt());
			
			int cnt = 1;
			int first = 0, newVal=0;
			
			//암호문 생성하기
			while(true) {
				
				//cnt값이 6이 되면 사이클이 끝났다는 뜻
				if(cnt == 6) {
					cnt = 1;
				}
				
				first = queue.peek();
				newVal = first-cnt;
				
				//뺏더니 0보다 작아지는 순간
				if(newVal<=0) {
					//이 값은 0으로 처리하고 뒤로 보낸 다음에 빠져나옴
					queue.offer(0);
					queue.poll(); 
					
					break;
				}
				else {
					queue.offer(newVal);
					queue.poll();
				}
				
				cnt++;

			}
			
			System.out.print("#"+tc+" ");
			
			while(!queue.isEmpty()) {
				System.out.print(queue.poll()+" ");
				//queue.poll();
			}
			System.out.println();
		}

	}

}
