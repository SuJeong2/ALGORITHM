package com.ssafy.day0213;

public class BFS_DFS_Test {

	public static void main(String[] args) {
		
		int size = 9;
		BFS bfsTree = new BFS(size);
		DFS dfsTree = new DFS(size);
		
		/*
		트리 구조
				A
			B		C
		  D   E    F  G
		H  I
		
		배열 구조
		0 1 2 3 4 5 6 7 8 9
		  A B C D E F G H I
		 */
		for(int i=0; i<size; i++) {
			bfsTree.add((char)(65+i));
			dfsTree.add((char)(65+i));
		}
		
		//BFS 탐색 순서 출력
		//A B C D E F G H I
		System.out.print("BFS 탐색 순서 : ");
		bfsTree.bfs();
		
		//BFS 탐색 + 트리 구조 출력
		System.out.println("\nBFS 탐색 순서+트리 구조");
		bfsTree.bfs2();
		
		System.out.println("\n=============\n");
		
		//DFS 탐색 순서 출력
		//A B D H I E C F G
		System.out.print("DFS 탐색 순서 : ");
		dfsTree.DFS();
	}

}
