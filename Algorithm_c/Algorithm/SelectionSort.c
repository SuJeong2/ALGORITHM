#include <stdio.h>

int max, min, temp;

//Ascending
void selection_max(int arr[], int n) {

	for (int i = n - 1; i >= 0; i--) {

		max = i;

		for (int j = 0; j <= i; j++) {

			if (arr[j] > arr[max])
				max = j;
		}

		//swap
		temp = arr[i];
		arr[i] = arr[max];
		arr[max] = temp;
	}
}

//Descending
void selection_min(int arr[], int n) {

	for (int i = 0; i < n; i++) {

		min = i;

		for (int j = n-1; j >= i; j--) {

			if (arr[j] > arr[min])
				min = j;
		}

		//swap
		temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
}

void print_sort(int arr[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
}

void main() {
	
	int arr[10] = { 29,10,14,1,5,30,12,8,22,0 };
	int arr2[10] = { 29,10,14,1,5,30,12,8,22,0 };
	int max = 0, max_index, temp;

	int n = sizeof(arr) / sizeof(int);
	int n2 = sizeof(arr) / sizeof(int);

	selection_max(arr, n);
	printf("Ascending, 오름차순: \n");
	print_sort(arr, n);


	printf("\n\n");

	selection_min(arr2, n2);
	printf("Descending, 내림차순: \n");
	print_sort(arr2, n2);
}