package com.ssafy.day0213;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	//트리 형태 - 배열로 구현
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;

	public BFS(int size) {
		super();
		SIZE = size;
		nodes = new char[size + 1];
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(char e) {
		if (isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	/*
	BFS
	- 루트를 시작으로 자식 노드를 방문 + 큐에 노드 번호 저장
	- 자식들 우선 탐색, Breath First
	
	- 큐에 자식들 정보를 넣어 놓고 하나씩 빼면서 탐색
	 */
	public void bfs() {
		if(isEmpty())
			return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		
		int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(nodes[current]+" ");
			
			if(current*2<=lastIndex) queue.offer(current*2);
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
	}
	
	/*
	큐에 들어가있는 사이즈 == 자식 노드의 개수
	그 사이즈만큼 돌면서 자식 노드를 큐에다 추가해주면 됨
	 */
	public void bfs2() {
		if(isEmpty())
			return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		
		int current,size, level = 0;
		while(!queue.isEmpty()) {
			
			size = queue.size();
			System.out.print("level "+level+": ");
			
			while(--size>=0) {				
				current = queue.poll();
				System.out.print(nodes[current]+" ");
				
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			level++;
			System.out.println();
		}
	}
}
