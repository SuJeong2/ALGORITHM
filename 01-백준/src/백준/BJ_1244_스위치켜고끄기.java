package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1244_스위치켜고끄기 {
	/*
	 * num - 스위치 개수
	 * student - 학생의 수
	 * bg - (1)남학생 (2)여학생
	 * switchN - 학생이 배정받은 스위치 번호
	 */
	static int num, student, bg, switchN;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();

		//스위치 번호를 1부터 시작하기 위해서 배열 크기를 num+1로 함
		int[] arr = new int[num+1];
		for(int i=1; i<=num; i++)
			arr[i]=sc.nextInt();
		
		student = sc.nextInt();
		//학생의 수만큼 반복
		for(int i=1; i<=student; i++) {
			bg=sc.nextInt();
			switchN=sc.nextInt();
			
			//남자일 경우
			if(bg==1) {
				int multiple = 1;
				while(multiple*switchN <= num) {
					int temp = arr[multiple*switchN];
					if(temp==0)
						arr[multiple*switchN]=1;
					else arr[multiple*switchN]=0;
					multiple+=1;
				}
			}
			
			//여자일 경우
			else {
				
				int index = switchN, way=1;
				
				if(arr[switchN]==0)
					arr[switchN]=1;
				else arr[switchN]=0;
				
				while(switchN-way>=1 && switchN+way<=num) {
					
					int left = switchN-way;
					int right = switchN+way;
					
					if(arr[left]==arr[right]) {
						if(arr[left]==0) {
							arr[left]=1;
							arr[right]=1;
						}
						else {
							arr[left]=0;
							arr[right]=0;
						}
					}
					
					else {
						break;
					}
					
					way+=1;
				}
				
			}
		}
		
		//출력 양식을 맞추기 위해서 다음처럼 함.
		for(int i=1; i<=num; i++) {
			System.out.print(arr[i]);
            if(i%20==0)
				System.out.println();
            else System.out.print(" ");
		}

	}

}
