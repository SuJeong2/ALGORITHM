package SWEA;

import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {

	//입력 값 처리
	static int T, H, W, N, r,c, head;
	static char[][] map;
	static char[] action;
	
	static String s;
	
	static char[] dir = {'^','v','<','>'};
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner("1\r\n4 6\r\n"
				+ "*.*..*\r\n"
				+ "*.....\r\n"
				+ "..-...\r\n"
				+ "^.*#..\r\n"
				+ "10\r\n"
				+ "SRSSRRUSSR");
		
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			H = sc.nextInt();
			W = sc.nextInt();
			
			map = new char[H][W];
			
			for(int i=0; i<H; i++) {
				s = sc.next();
				map[i] = s.toCharArray();
				
				for(int j=0; j<W; j++) {
					if(map[i][j]=='^' ||map[i][j]=='v'|| map[i][j]=='<'||map[i][j]=='>') {
						r=i;
						c=j;
					}	
				}
			}
			
			for(int k=0; k<4; k++) {
				if(map[r][c]==dir[k]) {
					head=k;
				}
			}
			//액션 동작 입력 받기
			N = sc.nextInt();
			action = new char[N];
			s = sc.next();
			action = s.toCharArray();
	
			simulation();
			
			// 출력
			System.out.print("#" + tc + " ");
			// 맵 출력
			printMap();
		}
	}

	public static void simulation() {
		char ac;
		
		for(int i=0; i<N; i++) {
			ac = action[i];
			
			if(ac=='S') {
				//벽을 만날 떄까지
				int newR=r+dx[head];
				int newC =c+dy[head];

				while(true) {
					//지역을 넘어가면 끝
					if(newR<0 || newR>=H || newC<0 || newC>=W)
						break;
					
					//벽돌로 지어진 벽
					if(map[newR][newC]=='*') {
						//평지로 바꿔주고 끝
						map[newR][newC]='.';
						break;
					}
					
					//강철로 지어진 벽 > 그냥 나옴
					if(map[newR][newC]=='#') {
						break;
					}
					
					newR+=dx[head];
					newC+=dy[head];
					
				}
			}
			//여기까지가 S 끝
			
			//방향에 따른 것일 경우
			// 1. 방향 전환 : head값으로
			// 2. 앞에 뭐가 있는지 없는지 check()
			// 3. 이동할 수 있다면 이동 + 평지로 바꾸기
			//		아니면 끝
			else {
				//1. 방향 전환
				head = headChange(ac);
				
				//2. 앞에 뭐가 있는지 체크
				boolean can = check();
				
				//3. 앞이 평지여서 움직일 수 있는 경우에만 움직이고, 있던 곳은 평지로
				if(can == true) {
					map[r][c]='.';
					
					//전차의 위치 이동
					r=r+dx[head];
					c=c+dy[head];
					
					//옮긴 위치에 전차
					map[r][c]=dir[head];
				}
				
			}
			
			
		}
	}
	
	public static boolean check() {
		int newR  = r+dx[head];
		int newC = c+dy[head];
		
		//앞이 바운더리를 넘어가는 경우 움직일 수 없음
		if(newR<0 || newR>=H || newC<0 || newC>=W)
			return false;
		
		if(map[newR][newC] == '.')
			return true;
		
		return false;
	}
	
	public static int headChange(char ac) {
        if(ac =='U')
            return 0;
        if(ac =='D')
            return 1;
        if(ac=='L')
            return 2;
        if(ac=='R')
            return 3;
		
        return -1;
	}
	
	public static void printMap() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}

}
