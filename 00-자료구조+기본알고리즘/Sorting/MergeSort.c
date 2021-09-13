#include <stdio.h>

void merging(int arr[], int left1, int right1, int left2, int right2) {
	int p, q;//p�� q�� ���� �ּڰ��� ����Ű�� ������
	int temp[100]; //������ ����� �����ϴ� �ӽú���
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
	//arr�� left���� end������ �պ������ϴ� �Լ�

	//��������
	if (left >= right)
		return;

	else {
		//1. ���� ������ �պ�����
		//2. ������ ������ �պ�����
		//3. �� ���� ��ģ��.

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