package 백준;

import java.util.Scanner;

public class BJ_2567_색종이2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[][] map = new boolean[101][101];
		int x,y;
		for(int n=0; n<N; n++) {
			x=sc.nextInt();
			y=sc.nextInt();
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++)
					map[i][j]=true;
			}
			
		}
		
		//탐색
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		int count=0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				
				if(map[i][j]==true) {
					for(int dir=0; dir<4; dir++) {
						if(map[i+dx[dir]][j+dy[dir]]==false)
							count++;
					}
				}
				
			}
		}
		
		System.out.println(count);
		
	}

}
