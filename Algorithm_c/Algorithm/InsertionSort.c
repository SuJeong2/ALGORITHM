#include <stdio.h>

//Ascending
void InsertionSort(int arr[], int n) {

	int temp;

	for (int i = 1; i < n; i++) {
		
		for (int j = i; j > 0; j--) {
			if (arr[j-1] > arr[j]) {
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}

	}
}

void print_sort(int arr[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
}

void main() {

	int arr[10] = { 29,10,14,1,5,30,12,8,22,0 };

	int n = sizeof(arr) / sizeof(int);

	InsertionSort(arr, n);
	printf("Insertion Sort, Ascending, 오름차순: \n");
	print_sort(arr, n);
}