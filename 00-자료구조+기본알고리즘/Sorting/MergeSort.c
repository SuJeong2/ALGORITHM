#include <stdio.h>

void merging(int arr[], int left1, int right1, int left2, int right2) {
	int p, q;//p와 q의 현재 최솟값을 가리키는 변수들
	int temp[100]; //합쳐진 결과를 저장하는 임시변수
	int temp_index = 0;

	p = left1;
	q = left2;

	while (p<=right1 && q<= right2) {
		if (arr[p] <= arr[q]) {
			temp[temp_index++] = arr[p];
			p++;
		}
		else {
			temp[temp_index++] = arr[q];
			q++;
		}
	}

	if (p > right1) {
		for (int i = q; i <= right2; i++)
			temp[temp_index++] = arr[i];
	}
	else {
		for (int i = p; i <= right1; i++)
			temp[temp_index++] = arr[i];
	}

	for (int i = left1; i <= right2; i++) {
		arr[i] = temp[i - left1];
	}
}

void MergeSort(int arr[], int left, int right) {
	//arr의 left부터 end까지를 합병정렬하는 함수

	//기저조건
	if (left >= right)
		return;

	else {
		//1. 왼쪽 절반을 합병정렬
		//2. 오른쪽 절반을 합병정렬
		//3. 그 둘을 합친다.

		int mid = (left + right) / 2;

		MergeSort(arr, left, mid);
		MergeSort(arr, mid + 1, right);

		merging(arr, left, mid, mid + 1, right);
	}
}

void print_sort(int arr[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
}

void main() {
	int arr[10] = { 29,10,14,1,5,30,12,8,22,0 };

	int n = sizeof(arr) / sizeof(int);

	MergeSort(arr, 0, n - 1);

	printf("Merge Sort: \n");

	print_sort(arr, n);
}