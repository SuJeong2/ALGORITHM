#include <stdio.h>

int getLeft(int arr[], int start, int end, int pivot, int result[]) {
	//arr의 start 부터 end까지 숫자들 중에서
	//pivot 보다 작거나 같은 값을 result에 채우는 함수
	//또한, 작거나 같은 원소의 개수를 반환

	int index = 0;

	for (int i = start; i <= end; i++) {
		if (arr[i] <= pivot) {
			result[index++] = arr[i];
		}
	}

	return index;
}

int getRight(int arr[], int start, int end, int pivot, int result[]) {
	int index = 0;

	for (int i = start; i <= end; i++) {
		if (arr[i] > pivot) {
			result[index++] = arr[i];
		}
	}

	return index;
}

void QuickSort(int arr[], int left, int right) {

	//함수 정의 : arr를 left부터 right까지 퀵정렬하는 함수

	//기저조건
	if (left >= right)
		return;

	int pivot = arr[left];
	int arr_left[100], arr_right[100];

	int left_cnt =  getLeft(arr, left + 1, right, pivot, arr_left);
	int right_cnt = getRight(arr, left + 1, right, pivot, arr_right);

	//arr <- arr_left + pivot + arr_right
	for (int i = 0; i < left_cnt; i++) {
		arr[left+i] = arr_left[i];
	}
	arr[left+left_cnt] = pivot;
	for (int i = 0; i < right_cnt; i++) {
		arr[left + left_cnt +1+ i] = arr_right[i];
	}

	QuickSort(arr, left, left + left_cnt - 1);
	QuickSort(arr, left + left_cnt + 1, right);
}

void print_sort(int arr[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
}

void main() {
	int arr[10] = { 29,10,14,1,5,30,12,8,22,0 };

	int n = sizeof(arr) / sizeof(int);

	QuickSort(arr, 0, n-1);

	printf("Quick Sort: \n");

	print_sort(arr, n);
}