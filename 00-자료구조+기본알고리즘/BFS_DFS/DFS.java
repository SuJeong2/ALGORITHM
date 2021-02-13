package com.ssafy.day0213;

import java.util.Stack;

public class DFS {
	//트리 형태 - 배열로 구현
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;

	public DFS(int size) {
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
	DFS - Depth First
	-루트를 시작으로 자신의 자식 노드를 쭉 방문 + 스택에 번호 저장
	- 자신의 자식을 호출 -> 그 자식이 또 자신의 자식 호출 -> 반복
	
	- 루트 노드에서 한 방향으로 갈 수 있는 경로가 있는 곳까지 깊이 탐색
	- 가장 마지막까지 내려가면 그 위 노드로 되돌아와서 다른 방향의 노드로 탐색
	
	- 그 전의 노드로 되돌아가야 함
	=> 재귀 혹은 후입선출 구조의 스택 이용
	 */
	public void DFS() {
		if(isEmpty()) return;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		
		int current;
		while(!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(nodes[current]+" ");
			
			//왼쪽 자식부터 탐색하도록 하기 위해서 오른쪽 노드 먼저 추가해줌
			//스택의 특성상 마지막에 있는 노드가 먼저 꺼내지기 때문
			if(current*2+1<=lastIndex) stack.push(current*2+1);
			if(current*2<=lastIndex) stack.push(current*2);
		}
	}
	
}
