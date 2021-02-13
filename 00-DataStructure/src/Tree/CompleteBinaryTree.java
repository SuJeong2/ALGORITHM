package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE=size;
		
		//노드 번호를 1부터 시작하기 위해서
		nodes = new char[size+1];
	}
	
	//lastIndex가 0일 경우 -> 아무 값도 없을 때
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	//lastIndex의 크기가 노드 배열의 크기와 같은 경우 -> 노드가 꽉 찬 이진트리가 된 경우
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	
	/*
	만약 꽉 차있다면 메세지 + return
	꽉 차지 않은 경우 배열에 값을 넣어줌
	++lastIndex -> 마지막 노드 번호를 가짐
	 */
	public void add(char c) {
		if(isFull()) {
			System.out.println("이진 트리가 꽉 찼습니다.");
			return;
		}
		
		nodes[++lastIndex] = c;
	}
	
	/*
	CompleteBinaryTree 완전 이진 트리
	특징을 이용하여 트리 출력
	
	각 level마다 2^level 개의 노드를 가진다.
	각 level의 첫 번째 노드 번호는 2^^level 과 같다.
	
	- 각 레벨마다 노드의 개수 (nodeNum)을 구해서 출력
	- 각 층의 첫 번째 노드 번호는 nodeNum부터 시작
	- 따라서 nodeNum + i 를 통해 트리 값 접근
	- i는 0부터 nodeNum(노드개수)까지 
	 */
	public void printTree() {
		int level = 0;
		boolean finish = true;
		
		while(finish) {
			int nodeNum = (int) Math.pow(2, level);
			
			System.out.print("Level " + level+" : ");
			for(int i=0; i<nodeNum&& finish; i++) {
				
				System.out.print(nodes[nodeNum+i]+" ");

				if(nodeNum+i==lastIndex) {
					finish=false;
					break;
				}	
			}
			System.out.println();
			level++;
		}
		
	}
}
