#include <stdio.h>

int temp;

//Ascending
void BubbleSort(int arr[], int n) {
	for (int i = n - 1; i > 0; i--) {
		
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[j + 1]){
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
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

	BubbleSort(arr, n);
	printf("Bubble sort, Ascending, 오름차순: \n");
	print_sort(arr, n);
}