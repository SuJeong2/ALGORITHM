package com.ssafy.Mar.day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {

	static int N;
	static int[][] map;
	static int[] shark;
	static int sharkSize;
	static int cnt, dis;
	static int[] loc;
	static int result;
	static boolean[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(rb.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		shark = new int[2];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(rb.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 9) {
					shark[0] = r;
					shark[1] = c;
				}
			}
		}
		
		map[shark[0]][shark[1]] = 0;
		// 초기 상어 크기 =2
		sharkSize = 2;
		cnt = 0; // 잡아먹은 물고기 개수
		dis = Integer.MAX_VALUE; // 최소 거리를 저장해둘 변수

		loc = new int[2]; // 최소거리가 되는 물고기 위치를 담음
		loc[0] = N + 1; // 초기값은 N+1로
		loc[1] = N + 1;

		boolean flag = false; // 물고기를 찾은 경우를 표시하기 위한 변수
		int ans = 0; // 결과 출력을 위한 변수 - 최소거리를 더하여 저장

		while (true) {
//			for(int r=0; r<N; r++) {
//				for(int c=0; c<N; c++) {
//					System.out.print(map[r][c]);
//				}
//				System.out.println();
//			}
//			System.out.println("==================");
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					//if (map[r][c] < sharkSize && map[r][c] >=1 && map[r][c]<=6) {
					if (map[r][c] < sharkSize && map[r][c] !=0) {
						visited = new boolean[N][N];

						// 상어의 위치와 먹이까지의 거리 구하기
						getDistance(r, c, 0);

						if (result == -1) {
							continue;
						}
						if(dis==result) {
							// 만약 거리가 같을 경우 -> 가장 위에 있거나, 왼쪽에 있는 물고기로
							if (r > loc[0])
								continue; // 최소거리 물고기보다 아래에 있을 경우 -> 필요없음
							if (r == loc[0] && c > loc[1])
								continue; // 가장 위쪽에 있는게 같으면 왼쪽에 있는 물고기,
							dis = result;
							loc[0] = r;
							loc[1] = c;
							flag = true;
							
						}
						else if (dis > result) {
							dis = result;
							loc[0] = r;
							loc[1] = c;
							flag = true;
							continue;
						}
					}
				}
			}

			if (flag) {
				map[shark[0]][shark[1]] = 0; // 상어가 원래 있던 자리는 0으로 바꿔줌(탐색하기 위해)

				// 상어 위치를 물고기 위치로
				shark[0] = loc[0];
				shark[1] = loc[1];

				// System.out.println("상어 새로운 위치 "+shark[0]+ " "+shark[1]);

				// 먹은 물고기 자리는 0이 된다
				map[loc[0]][loc[1]] = 0;
				cnt++; // 물고기 먹은 개수 증가

				// 상어의 크기만큼 먹었다면 상어의 크기 증가, 먹은 물고기 개수 초기화
				if (cnt == sharkSize) {
					sharkSize++;
					cnt = 0;
				}

				ans += dis;// 이동 거리를 결과에 더하고

				// 다음 이동을 위해 변수 값들을 돌려 놓음
				dis = Integer.MAX_VALUE;
				flag = false;
				loc[0] = N + 1;
				loc[1] = N + 1;

			} else {
				break;
			}
		}
		
		// 결과 출력
		System.out.println(ans);

	}

	private static void getDistance(int r, int c, int len) {

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { shark[0], shark[1], len });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {

				int nr = current[0] + dx[i];
				int nc = current[1] + dy[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				if (map[nr][nc] > sharkSize) // 상어의 크기보다 큰 물고기는 지나갈 수 없다
					continue;

				if (nr == r && nc == c) { // 만약 물고기의 위치를 찾았다면
					result = current[2] + 1; // 거리를 반환
					return;
				}

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc, current[2] + 1 });
			}

		}
		
		//못 찾은 경우
		result=-1;

	}

}